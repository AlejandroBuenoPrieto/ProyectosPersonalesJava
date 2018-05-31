package aed.ejercicios.usodelistas;

import java.util.Iterator;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;

import es.upm.aedlib.positionlist.PositionList;

public class sumaPositionList {
	public static  void main(String [] args){
		PositionList<Integer> a= new NodePositionList<Integer>();
		PositionList<Integer> b= new NodePositionList<Integer>();
		a.addLast(3);
		a.addLast(7);
		b.addLast(5);
		b.addLast(6);
		b.addLast(7);
		b.addLast(8);
		b.addLast(9);
		System.out.println(join(a,b));
	}
	public static <E> PositionList<Integer> join (PositionList<Integer> l1, PositionList<Integer> l2){
		PositionList<Integer> sol = new NodePositionList<Integer>();
		Position <Integer> cursor= l1.first();
		Position <Integer> cursordos= l2.first();
		while(cursor!=null && cursordos!=null){
             if(cursor.element().compareTo(cursordos.element())>0){
            	 sol.addLast(cursordos.element());
            	 cursordos=l2.next(cursordos);
             }
             if(cursor.element().compareTo(cursordos.element())<0){
            	 sol.addLast(cursor.element());
            	 cursor= l1.next(cursor);
             }
             if(cursor.element().compareTo(cursordos.element())==0){
            	 sol.addLast(cursor.element());
            	 sol.addLast(cursordos.element());
            	 cursor= l1.next(cursor);
            	 cursordos= l2.next(cursordos);
             }
		}
		while(cursor!=null){
			sol.addLast(cursor.element());
			cursor= l1.next(cursor);
		}
		while(cursordos!=null){
			sol.addLast(cursordos.element());
			cursordos = l2.next(cursordos);
		}
		return sol;
		
	}
}
