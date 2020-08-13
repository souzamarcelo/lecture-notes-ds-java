package search.binary;

import java.util.Comparator;

import linear.list.List;
import search.sequential.Entry;

public class GenericBinaryEntrySearch<K,V> {
	
	Comparator<K> comp;
	
	public GenericBinaryEntrySearch() {
		this(new DefaultComparator<K>());
	}
	
	public GenericBinaryEntrySearch(Comparator<K> c) {
		comp = c;
	}
	
	public V searchElement(List<Entry<K,V>> array, K key) {
		int start = 0;
		int end = array.size() - 1;
		int mid;
		
		do {
			mid = (start + end) / 2;
			if(comp.compare(array.get(mid).getKey(), key) < 0)
				start = mid + 1;
			else
				end = mid - 1;
			
		} while(comp.compare(array.get(mid).getKey(), key) != 0 && start <= end);
		
		if(comp.compare(array.get(mid).getKey(), key) == 0)
			return array.get(mid).getValue();
		else
			return null;
	}
}
