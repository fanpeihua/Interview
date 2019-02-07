package collection;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by perryFan on 2019/2/7.
 */
public class MyHashMap<K, V> extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable {

    private static final long serialVersionUID = 362498820763181265L;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int TREEIFY_THRESHOLD = 8;

    static final int MIN_TREEIFY_CAPACITY = 64;

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
        }

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
