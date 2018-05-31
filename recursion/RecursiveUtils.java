package aed.recursion;

import es.upm.aedlib.Position;
import es.upm.aedlib.positionlist.*;

public class RecursiveUtils {
	/**
	 * Return a^n.
	 * 
	 * @return a^n.
	 */
	public static int power(int a, int n) {
		if (n == 0) {
			return 1;
		}
		if (n % 2 == 0)
			return power(a * a, n / 2);
		else
			return a * power(a * a, n / 2);
	}

	/**
	 * Returns true if the list parameter does not contain a null element.
	 * 
	 * @return true if the list does not contain a null element.
	 */
	public static <E> boolean allNonNull(PositionList<E> l) {
		if (l.size() != 0)
			return allNonNullRec(l, l.first());
		else
			return true;
	}

	public static <E> boolean allNonNullRec(PositionList<E> l, Position<E> cursor) {
		if (cursor.element() == null) {
			return false;
		}
		if (l.last().equals(cursor)) {
			return true;
		} else
			return allNonNullRec(l, l.next(cursor));
	}

	/**
	 * Returns the number of non-null elements in the parameter list.
	 * 
	 * @return the number of non-null elements in the parameter list.
	 */
	public static <E> int countNonNull(PositionList<E> l) {
		if (l.size() == 0)
			return 0;
		else
			return countNonNullRec(l, l.first());
	}

	public static <E> int countNonNullRec(PositionList<E> l, Position<E> cursor) {
		if (cursor != null) {
			if (cursor.element() != null) {
				return 1 + countNonNullRec(l, l.next(cursor));
			} else
				return countNonNullRec(l, l.next(cursor));

		} else
			return 0;

	}
}
