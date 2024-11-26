import java.util.Set;

public interface MyMap<K, V> {
    // Remove all of the entries from this map
    void clear();

    // Return true if this map contains the specified key
    boolean containsKey(K key);

    // Return true if this map contains the specified value
    boolean containsValue(V value);

    // Return the value associated with the specified key
    V get(K key);

    // Return true if this map contains no entries
    boolean isEmpty();

    // Add an entry (key, value) into the map
    V put(K key, V value);

    // Remove the entry for the specified key
    V remove(K key);

    // Return the number of mappings in this map
    int size();

    // Return a set of all keys in this map
    Set<K> keySet();

    // Return a set of all values in this map
    Set<V> values();
}
