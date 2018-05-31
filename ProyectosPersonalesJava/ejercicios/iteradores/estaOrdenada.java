package aed.ejercicios.iteradores;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;

public class estaOrdenada {
	static <E extends Comparable<E>> boolean estaOrdenada(PositionList<E> list) {
		boolean enc = true;
		if (list.size() <= 1)
			return true;
		else {
			Position<E> cursor = list.first();
			while (cursor != null && enc) {
				if (cursor.element().compareTo(list.next(cursor).element()) < 0)
					enc = false;
			}
			cursor = list.next(cursor);
			return enc;
		}
	}

}
