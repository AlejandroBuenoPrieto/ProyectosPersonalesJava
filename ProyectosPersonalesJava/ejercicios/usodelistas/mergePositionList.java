package aed.ejercicios.usodelistas;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class mergePositionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public PositionList<Integer>fairOrderMerge(PositionList<Integer> l1, PositionList<Integer> l2){
		PositionList<Integer> sol= new NodePositionList<Integer>();
		Position<Integer> cursor1= l1.first();
		Position<Integer> cursor2= l2.first();
		while(cursor1!=null && cursor2!=null){
			if(cursor1.element().compareTo(cursor2.element())>0){
				sol.addLast(cursor1.element());
				cursor1=l1.next(cursor1);
			}
			if(cursor1.element().compareTo(cursor2.element())<0){
				sol.addLast(cursor2.element());
				cursor2=l2.next(cursor1);
			}
			if(cursor1.element().compareTo(cursor2.element())==0){
				sol.addLast(cursor1.element());
				cursor1=l1.next(cursor1);
				sol.addLast(cursor1.element());
				cursor2=l2.next(cursor1);
			}
			
		}
		while(cursor1!=null){
			sol.addLast(cursor1.element());
			cursor1=l1.next(cursor1);
		}
		while(cursor2!=null){
			sol.addLast(cursor2.element());
			cursor2=l2.next(cursor2);
		}
		
		return sol;
		
	}

}
