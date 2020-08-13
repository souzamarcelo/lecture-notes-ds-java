package linear.map;

import linear.list.ArrayList;

public class UnsortedTableMap<K,V> implements Map<K,V> {

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
	
	private ArrayList<MapEntry<K,V>> table = new ArrayList<>();

	public int size() { return table.size(); }
	public boolean isEmpty() { return size() == 0; }
	
	private int findIndex(K key) {
		int n = table.size();
		for (int j=0; j < n; j++)
			if (table.get(j).getKey().equals(key))
				return j;
		return -1;
	}

	public V get(K key) {
		int j = findIndex(key);
		if (j == -1) return null;
		return table.get(j).getValue();
	}

	public V put(K key, V value) {
		int j = findIndex(key);
		if (j == -1) {
			table.add(new MapEntry<>(key, value));
			return null;
		} else
			return table.get(j).setValue(value);
	}

	public V remove(K key) {
		int j = findIndex(key);
		int n = size();
		if (j == -1) return null;
		V answer = table.get(j).getValue();
		if (j != n - 1)
			table.set(j, table.get(n-1));
		table.remove(n-1);
		return answer;
	}
	
	public String toString() {
		return table.toString();
	}
}