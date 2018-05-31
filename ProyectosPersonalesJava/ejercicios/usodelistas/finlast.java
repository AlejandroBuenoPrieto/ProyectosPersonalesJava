package aed.ejercicios.usodelistas;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class finlast {

	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		PositionList<Integer> sol= new NodePositionList<Integer>();
		int i = 0;
		sol.addLast(5);
		sol.addLast(4);
		sol.addLast(null);
        sol.addLast(5);
        findLast(sol,null);
        System.out.println(sol);


	}
	public static <E> Position<E> findLast(PositionList<E> list, E e){
		Position <E> sol=null;
		Position<E> cursor= list.first();
		while(cursor!=null){
			if(cursor.element()==null && e==null){
				sol=cursor;
				
			}
			else{
				if(cursor.element().equals(e)){
				sol=cursor;	
				
			}
				
			}
			cursor= list.next(cursor);
		}
		return sol;
	}
}
