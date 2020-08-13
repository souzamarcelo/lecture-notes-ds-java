package search.sequential;

import java.util.Comparator;

import linear.list.List;

public class GenericSequentialSearch<E> {
	
	Comparator<E> comp;
	
	public GenericSequentialSearch() {
		this(new DefaultComparator<E>());
	}
	
	public GenericSequentialSearch(Comparator<E> c) {
		comp = c;
	}
	
	public int indexOf(E[] array, E value) {
		for(int i = 0; i < array.length; i++)
			if(comp.compare(array[i], value) == 0) {
				return i;
			}
		
		return -1;
	}
	
	public int indexOf(List<E> array, E value) {
		for(int i = 0; i < array.size(); i++)
			if(comp.compare(array.get(i), value) == 0) {
				return i;
			}
		
		return -1;
	}
}
