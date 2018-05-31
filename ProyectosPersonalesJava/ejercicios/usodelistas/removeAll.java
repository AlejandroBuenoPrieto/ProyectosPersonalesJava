package aed.ejercicios.usodelistas;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class removeAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PositionList<Integer> sol= new NodePositionList<Integer>();
		sol.addLast(1);
		sol.addLast(2);
		sol.addLast(5);
		sol.addLast(null);
		sol.addLast(5);
		removeAll(sol,5);
		System.out.println(sol);
	}
	public static void removeAll(PositionList<Integer> list, Integer e){
		Position<Integer> a=list.first();
		while(a!=null){
			if(a.element()!=null && a.element().equals(e)){
				Position<Integer> aux= list.next(a);
				list.remove(a);
				a=aux;
			}
			else{
				a=list.next(a);
			}
		}
	}
}
