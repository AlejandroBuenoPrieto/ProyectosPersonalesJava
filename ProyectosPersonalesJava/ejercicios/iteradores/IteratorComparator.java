package aed.ejercicios.iteradores;
import java.util.Comparator;
import java.util.Iterator;


public class IteratorComparator<E> implements Comparator<Iterator<E>> {
	private Comparator<E> compElem;

	public IteratorComparator(Comparator<E> compElem) {
		this.compElem = compElem;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int compare(Iterator<E> it1, Iterator<E> it2) {
		// TODO Auto-generated method stub
		int i = 0;
		while (it1.hasNext() && it2.hasNext() &&
		(i = compElem.compare(it1.next(),it2.next())) == 0)
		;
		if (i==0 && (it1.hasNext() || it2.hasNext()))
		i = it1.hasNext() ? 1 : -1 ;
		return i;
	}

}
