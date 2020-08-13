package linear.map;

public interface SortedMap<K,V> extends Map<K,V> {
	Entry<K,V> firstEntry();
	Entry<K,V> lastEntry();
	Entry<K,V> ceilingEntry(K key);
	Entry<K,V> floorEntry(K key);
	Entry<K,V> lowerEntry(K key);
	Entry<K,V> higherEntry(K key);
}