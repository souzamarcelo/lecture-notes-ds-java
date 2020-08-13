package search.sequential;

import java.util.Comparator;

import linear.list.List;

public class GenericSequentialEntrySearch<K, V> {
	
	Comparator<K> comp;
	
	public GenericSequentialEntrySearch() {
		this(new DefaultComparator<K>());
	}
	
	public GenericSequentialEntrySearch(Comparator<K> c) {
		comp = c;
	}
	
	public V searchElement(List<Entry<K,V>> array, K key) {
		for(int i = 0; i < array.size(); i++) {
			if(comp.compare(array.get(i).getKey(), key) == 0) {
				return array.get(i).getValue();
			}
		}
		return null;
	}
}
