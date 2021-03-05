import java.util.*;

public class ArrayMap<K, V> extends AbstractMap<K, V> {
    class ArrayMapEntry<K, V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        public String toString() {
            return key + " : " + value;
        }

        public boolean equals(Object obj) {
            if(obj instanceof ArrayMapEntry) {
                ArrayMapEntry o = (ArrayMapEntry) obj;

                if(o == this) {
                    return true;
                }

                if(o.value == value && o.key == key) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (key != null ? key.hashCode() : 0)
                    ^ (value != null ? value.hashCode() : 0);
        }
    }

    ArrayList<ArrayMapEntry<K, V>> list;

    public ArrayMap() {
        list = new ArrayList<ArrayMapEntry<K, V>>();
    }

    public V put(K key, V value) {
        for (ArrayMapEntry e:
             list) {
            if(key == e.getKey()) {
                V oldValue = (V)e.getValue();
                e.setValue(value);
                return oldValue;
            }
        }

        list.add(new ArrayMapEntry(key, value));
        return null;
    }

    public int size() {
        return list.size();
    }

    public Set entrySet() {
        return new HashSet(list);
    }
}

