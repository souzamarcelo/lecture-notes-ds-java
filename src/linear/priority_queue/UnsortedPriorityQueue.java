package linear.priority_queue;

import java.util.Comparator;

import linear.positional_list.LinkedPositionalList;
import linear.positional_list.Position;
import linear.positional_list.PositionalList;

public class UnsortedPriorityQueue<K, V> implements PriorityQueue<K, V> {
	
	protected static class PQEntry<K,V> implements Entry<K,V> {
		private K k;
		private V v;
		
		public PQEntry(K key, V value) {
			k = key;
			v = value;
		}
		
		public K getKey() { return k; }
		public V getValue() { return v; }
		protected void setKey(K key) { k = key; }
		protected void setValue(V value) { v = value; }
	}
	
	private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>();
	private Comparator<K> comp;
	
	public UnsortedPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	
	public UnsortedPriorityQueue(Comparator<K> c) {
		comp = c;
	}
	
	protected int compare(Entry<K,V> a, Entry<K,V> b) {
		return comp.compare(a.getKey(), b.getKey());
	}
	
	protected boolean checkKey(K key) {
		try {
			return (comp.compare(key, key)) == 0;
		} catch(ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	private Position<Entry<K, V>> findMin() {
		Position<Entry<K,V>> small = list.first();
		Position<Entry<K,V>> walk = small;
		while(walk != null) {
			if(compare(walk.getElement(), small.getElement()) < 0)
				small = walk;
			walk = list.after(walk);
		}
		return small;
	}

	public Entry<K, V> insert(K key, V value) {
		checkKey(key);
		Entry<K,V> newest = new PQEntry<>(key, value);
		list.addLast(newest);
		return newest;
	}

	public Entry<K, V> min() {
		if(list.isEmpty()) return null;
		return findMin().getElement();
	}

	public Entry<K, V> removeMin() {
		if(list.isEmpty()) return null;
		return list.remove(findMin());
	}
	
	public int size() { return list.size(); }
	
	public String toString() {
		StringBuilder sb = new StringBuilder("(");
		Position<Entry<K,V>> walk = list.first();
		while(walk != null) {
			sb.append(walk.getElement().getValue() + " [" + walk.getElement().getKey() + "]");
			walk = list.after(walk);
			if (walk != null)
				sb.append(", ");
		}
		sb.append(")");
		return sb.toString();		
	}
}
