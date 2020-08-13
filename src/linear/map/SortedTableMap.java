package linear.map;

import java.util.Comparator;
import linear.list.ArrayList;

public class SortedTableMap<K,V> implements SortedMap<K,V> {

	protected static class MapEntry<K,V> implements Entry<K,V> {
		private K k;
		private V v;

		public MapEntry(K key, V value) {
			k = key;
			v = value;
		}

		public K getKey() { return k; }
		public V getValue() { return v; }

		protected void setKey(K key) { k = key; }
		protected V setValue(V value) {
			V old = v;
			v = value;
			return old;
		}

		public String toString() { return "<" + k + ", " + v + ">"; }
	}
	
	
	private Comparator<K> comp;
	private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

	protected SortedTableMap(Comparator<K> c) {
		comp = c;
	}

	protected SortedTableMap() {
		this(new DefaultComparator<K>());
	}
	
	public int size() { return table.size(); }
	public boolean isEmpty() { return size() == 0; }
	
	protected boolean checkKey(K key) {
		try {
			return (comp.compare(key,key) == 0);
		} catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	private int findIndex(K key) { return findIndex(key, 0, table.size() - 1); }
	
	private int findIndex(K key, int low, int high) {
		if (high < low) return high + 1;
		int mid = (low + high) / 2;
		int result = comp.compare(key, table.get(mid).getKey());
		if (result == 0)
			return mid;
		else if (result < 0)
			return findIndex(key, low, mid - 1);
		else
			return findIndex(key, mid + 1, high);
	}

	public V get(K key) {
		checkKey(key);
		int j = findIndex(key);
		if (j == size() || comp.compare(key, table.get(j).getKey()) != 0) return null;
		return table.get(j).getValue();
	}

	public V put(K key, V value) {
		checkKey(key);
		int j = findIndex(key);
		if (j < size() && comp.compare(key, table.get(j).getKey()) == 0)
			return table.get(j).setValue(value);
		table.add(j, new MapEntry<K,V>(key,value));
		return null;
	}

	public V remove(K key) {
		checkKey(key);
		int j = findIndex(key);
		if (j == size() || comp.compare(key, table.get(j).getKey()) != 0) return null;
		return table.remove(j).getValue();
	}

	private Entry<K,V> safeEntry(int j) {
		if (j < 0 || j >= table.size()) return null;
		return table.get(j);
	}

	public Entry<K,V> firstEntry() { return safeEntry(0); }

	public Entry<K,V> lastEntry() { return safeEntry(table.size()-1); }

	public Entry<K,V> ceilingEntry(K key) {
		return safeEntry(findIndex(key));
	}

	public Entry<K,V> floorEntry(K key) {
		int j = findIndex(key);
		if (j == size() || ! key.equals(table.get(j).getKey()))
			j--;
		return safeEntry(j);
	}

	public Entry<K,V> lowerEntry(K key) {
		return safeEntry(findIndex(key) - 1);
	}

	public Entry<K,V> higherEntry(K key) {
		int j = findIndex(key);
		if (j < size() && key.equals(table.get(j).getKey()))
			j++;
		return safeEntry(j);
	}
	
	public String toString() {
		return table.toString();
	}
}