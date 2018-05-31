package aed.cache;

import es.upm.aedlib.Position;
import es.upm.aedlib.map.*;
import es.upm.aedlib.positionlist.*;


public class Cache<Key,Value> {
  private int maxCacheSize;
  private Storage<Key,Value> storage;
  private Map<Key,CacheCell<Key,Value>> map;
  private PositionList<Key> lru;
  
  public Cache(int maxCacheSize, Storage<Key,Value> storage) {
    this.storage = storage;
    this.map = new HashTableMap<Key,CacheCell<Key,Value>>();
    this.lru = new NodePositionList<Key>();
    this.maxCacheSize = maxCacheSize;
  }
  
  public Value get(Key key) {
    // CAMBIA este metodo
	  if(map.get(key)!=null){
		  if(lru.size()!=1){
		  Position<Key> p= lru.first();
		  while(!p.element().equals(key)){
			  p=lru.next(p);
		  }	  
		  }
		 
	  }
	  else{
		  Value v= storage.read(key);
		  lru.addFirst(key);
		  CacheCell<Key,Value> c = new CacheCell<Key, Value>(v,false,lru.first());
		  map.put(key, c);
		  if(map.size()==maxCacheSize+1){
			  map.remove(lru.last().element());
			  lru.remove(lru.last());
			  if(c.getDirty()==true){
				  storage.write(key, v);
			  }
		  }
		
	  }
   return map.get(key).getValue();
  }
  
  public void put(Key key, Value value) {
    // CAMBIA este metodo
	  System.out.println(lru.size());
	  if(lru.size()!=0){
		  System.out.println(lru.first().element());
	  }
	  if(map.get(key)!=null){
		  
		  
	  }
	  else{
		  lru.addFirst(key);
		  CacheCell<Key,Value> c = new CacheCell<Key,Value>(value, false, lru.first());
		  map.put(key, c);
		  if(map.size()==maxCacheSize){
			  map.remove(lru.last().element());
			  lru.remove(lru.last());
			  if(c.getDirty()==true){
				  storage.write(key, value);
			  }
		  }
	  }
	  map.get(key).setValue(value);
	  map.get(key).setDirty(true);
  }
}

