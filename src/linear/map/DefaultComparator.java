package linear.map;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {
	public int compare(E a, E b) {
		return ((Comparable<E>) a).compareTo(b);
	}
}
