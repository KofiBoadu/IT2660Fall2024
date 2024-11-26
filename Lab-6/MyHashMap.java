import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;

public class MyHashMap<K, V> implements MyMap<K, V> {
    // Define the initial capacity
    private static final int INITIAL_CAPACITY = 4;

    // Define the maximum load factor
    private static final float MAX_LOAD_FACTOR = 0.75f;

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public MyHashMap() {
        table = new LinkedList[INITIAL_CAPACITY];
    }

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                table[i].clear();
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            for (Entry<K, V> entry : table[bucketIndex]) {
                if (entry.key.equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    if (entry.value.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            for (Entry<K, V> entry : table[bucketIndex]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[bucketIndex]) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        table[bucketIndex].add(new Entry<>(key, value));
        size++;

        if (size >= table.length * MAX_LOAD_FACTOR) {
            rehash();
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            for (Entry<K, V> entry : table[bucketIndex]) {
                if (entry.key.equals(key)) {
                    table[bucketIndex].remove(entry);
                    size--;
                    return entry.value;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    set.add(entry.key);
                }
            }
        }
        return set;
    }

    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    set.add(entry.value);
                }
            }
        }
        return set;
    }

    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (table.length - 1);
    }

    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private void rehash() {
        Set<Entry<K, V>> entries = entrySet();
        table = new LinkedList[table.length * 2];
        size = 0;

        for (Entry<K, V> entry : entries) {
            put(entry.key, entry.value);
        }
    }

    private Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                for (Entry<K, V> entry : table[i]) {
                    set.add(entry);
                }
            }
        }
        return set;
    }

    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

