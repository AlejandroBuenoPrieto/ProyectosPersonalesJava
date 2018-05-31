package aed.ejercicios.usodelistas;
import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;

public class borrarconsecutivosiguales {
	public static void main(String [] args){
		PositionList<Integer> lista= new NodePositionList<Integer>();
		lista.addLast(5);
		lista.addLast(5);
		lista.addLast(3);
		lista.addLast(null);
		lista.addLast(null);
		eliminarConsecIguales(lista);
		System.out.println(lista);
		NodePositionList<Integer> list;
		
		
	}
	static <E> void eliminarConsecIguales (PositionList<Integer> lista){
		Position<Integer> cursor= lista.first();
		Position<Integer> aux=lista.next(cursor);
		while(aux!=null && cursor!=null){
			if(aux.element()==null && cursor.element()==null){
				Position<Integer> sig=lista.next(cursor);
				lista.remove(cursor);
				cursor=sig;
				aux=lista.next(cursor);
			}
			if(cursor.element()!= null && cursor.element().equals(aux.element())){
				Position<Integer> e=lista.next(cursor);
				lista.remove(cursor);
				cursor=e;
				aux=lista.next(cursor);
			}
			else{
				cursor= lista.next(cursor);
				if(aux!=null)
                aux= lista.next(aux);
			}
		}
	}
}
