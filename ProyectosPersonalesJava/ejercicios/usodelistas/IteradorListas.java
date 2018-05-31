package aed.ejercicios.usodelistas;

import java.util.Iterator;
import java.util.NoSuchElementException;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.PositionList;

public class IteradorListas<E> implements Iterator<E> {

	protected PositionList<E> list; // la lista sobre la que se itera protected
	protected Position<E> cursor; // Position<E> cursor; // la siguiente
	// posición en el recorrido

	/**
	 * Crea un objeto iterador para la lista pasada como argumento.
	 * 
	 * @param <cursor>
	 */
	public <cursor> IteradorListas(PositionList<E> L) {
		list = L;
		cursor = (list.isEmpty()) ? null : list.first();
	}

	public boolean hasNext() {
		return (cursor != null);
	}

	public E next() throws NoSuchElementException {
		if (cursor == null)
			throw new NoSuchElementException("No hay siguiente elemento");
		E elem = cursor.element();
		cursor = (cursor == list.last()) ? null : list.next(cursor);
		return elem;
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("remove");
	}

	public static <E> boolean iguales(PositionList<E> l1, PositionList<E> l2) {
		IteradorListas<E> it1 = new IteradorListas<E>(l1);
		IteradorListas<E> it2 = new IteradorListas<E>(l2);
		if (l1.size() != l2.size())
			return false;
		else {
			boolean enc = true;
			while (it1.hasNext() && it2.hasNext()) {
				if (!it1.next().equals(it2.next()))
					enc = false;
			}
			return enc;
		}

	}

}
