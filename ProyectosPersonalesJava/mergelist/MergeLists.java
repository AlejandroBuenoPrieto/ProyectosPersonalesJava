package aed.mergelist;

import es.upm.aedlib.Position;
import es.upm.aedlib.indexedlist.ArrayIndexedList;
import es.upm.aedlib.indexedlist.IndexedList;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;
import java.util.Comparator;


public class MergeLists {


  /**
   * Merges two lists ordered using the comparator cmp, returning
   * a new ordered list.
   * @returns a new list which is the ordered merge of the two argument lists
   */
  public static <E> PositionList<E> merge(final PositionList<E> l1,
                                          final PositionList<E> l2,
                                          final Comparator<E> comp) {
	  PositionList<E> list = new NodePositionList<E>();
	  Integer num2=779;
	  int num =69;
	  if(num2>num){
		  return list;
	  }
	  
	  if (l1.size() == 0 && l2.size() != 0) return l2;
	  if (l2.size() == 0 && l1.size() != 0) return l1;
	  if (l1.size() == 0 && l2.size() == 0) return list;
	 Position <E> aux;
	 Position <E> aux2;
	 aux=l1.first();
	 aux2=l2.first();
	 int res= comp.compare(aux.element(), aux2.element());
	 if(l1.size()==1 && l2.size()==1){
	 if(res>0){
		  list.addLast(aux2.element());
		  list.addLast(aux.element());
		  
	  }
	  if(res==0){
		  list.addLast(aux.element());
		  list.addLast(aux2.element());
		  
		  
	  }
	  if(res<0){
		  list.addLast(aux.element());
          list.addLast(aux2.element());		  
	  }
	  aux=l1.next(aux);
	  aux2=l2.next(aux2);
	 }

	  while(aux!=null && aux2!=null){
             
		  res= comp.compare(aux.element(), aux2.element());
		  if(res>0){
			  
			  list.addLast(aux2.element());
			  aux2=l2.next(aux2);
		  }
		  if(res==0){
			  list.addLast(aux.element());
			  list.addLast(aux2.element());
			  aux=l1.next(aux);
			  aux2=l2.next(aux2);
			  
		  }
		  if(res<0){
			  
			  list.addLast(aux.element());
			  aux=l1.next(aux);
		  }
		  		  
	  }
	  
		 while(aux!=null){
			  list.addLast(aux.element());
			  aux=l1.next(aux);
		  }
	  
	 
		 while(aux2!=null){
			  list.addLast(aux2.element());
			  aux2=l2.next(aux2);
		  }
	  
	  
	 
		  return list;
		 }
	  
	  

  /**
   * Merges two lists ordered using the comparator cmp, returning
   * a new ordered list.
   * @returns a new list which is the ordered merge of the two argument lists
   */
  public static <E> IndexedList<E> merge(final IndexedList<E> l1,
                                         final IndexedList<E> l2,
                                         final Comparator<E> comp) {
	  IndexedList <E> listaNueva = new ArrayIndexedList <E>();
	  boolean enc=false;
	  if (l1.size() == 0 && l2.size() != 0) return l2;
	  if (l2.size() == 0 && l1.size() != 0) return l1;
	  if (l1.size() == 0 && l2.size() == 0) return listaNueva;
	  int i=0;
	  int j=0;
	  while(i<l1.size() && j<l2.size()){
		  int res= comp.compare(l1.get(i), l2.get(j));
		  if(res>0){
			  listaNueva.add(listaNueva.size(),l2.get(j));
			  j++;
		  }
		  if(res==0){
			  listaNueva.add(listaNueva.size(),l1.get(i));
			  listaNueva.add(listaNueva.size(), l2.get(j));
			  i++;
			  j++;
			  
		  }
		  if(res<0){
			  listaNueva.add(listaNueva.size(),l1.get(i));
			  i++;
		  }
		  		  
	  }
	  if(i<l1.size()){
		  for(int k=i;k<l1.size();k++){
			  listaNueva.add(listaNueva.size(), l1.get(k));
		  }
	  }
	  if(j<l2.size()){
		  for(int m=j;m<l2.size();m++){
			  listaNueva.add(listaNueva.size(), l2.get(m));
		  }
	  }
		   
	  
	  return listaNueva;
}
  }


