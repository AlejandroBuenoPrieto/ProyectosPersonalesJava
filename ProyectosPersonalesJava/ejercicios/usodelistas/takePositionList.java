package aed.ejercicios.usodelistas;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.NodePositionList;
import es.upm.aedlib.positionlist.PositionList;

public class takePositionList<E> {
	public PositionList<E> take(int n, PositionList<E> list) {
		PositionList<E> rlist = new NodePositionList<E>(); // lista resultado
															// vacia
		if (list.size() == 0)
			return rlist;
		else {
			Position<E> cursor = list.first();
			int i = 0;
			while (i <= n && cursor != null) {
				rlist.addLast(cursor.element());
				i++;
				cursor = list.next(cursor);
			}
			return rlist;
		}

	}
}
