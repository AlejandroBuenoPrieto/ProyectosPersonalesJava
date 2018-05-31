package aed.ejercicios.usodelistas;

import es.upm.aedlib.indexedlist.ArrayIndexedList;
import es.upm.aedlib.indexedlist.IndexedList;

public class takeIndexedList<E> {
	public IndexedList<E> take(int n, IndexedList<E> list) { 
		IndexedList<E> res = new ArrayIndexedList<E>() ; // lista resultado /** COMPLETAR **/ }
		if(list.size()==0)
		return res;
		else{
			for(int i=0;i<n-1;i++){
				res.add(i, list.get(i));
			}
			return res;
		}
	}
}
