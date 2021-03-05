import java.util.*;

public class ArrayMap<K,V> extends AbstractMap<K,V> {
    private Vector<K> keys;
    private Vector<V> value;

    public ArrayMap() {
        keys = new Vector<K>();
        value = new Vector<V>();
    }

    public String toString() {
        int i;
        String s = "";

        for(i = 0; i < keys.size(); i++) {
            s += "key: " + keys.get(i) + " ";
            s += "value: " + value.get(i) + "\n";
        }

        return s;
    }

    @Override
    public V put(K key, V value) {
        if(keys.contains(key)) {
            int i;
            i = keys.indexOf(key);
            V oldValue = this.value.get(i);
            this.value.addElement(value);
            return oldValue;
        }
        keys.addElement(key);
        this.value.addElement(value);

        return value;
    }

    public V get(Object obj) {
        if(keys.contains(obj)) {
            int i = keys.indexOf(obj);
            return value.get(i);
        }

        return (V)obj;
    }

    public Set<K> keySet() {
        Set s = new HashSet(keys);
        return s;
    }

    public Collection<V> values() {
        return value;
    }

    class ArrayMapEntry<K,V> implements Map.Entry<K, V> {
        private K key;
        private V value;

        public ArrayMapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value= value;
            return oldValue;
        }

        public void setKey(K key) {
            this.key = key;
        }
    }

    public Set entrySet() {
        int i;
        Set<ArrayMapEntry<K,V>> s = new HashSet<>();
        for(i = 0; i < keys.size(); i++) {
            ArrayMapEntry<K,V> entry = new ArrayMapEntry<>(
                    keys.elementAt(i), value.elementAt(i));
            s.add(entry);
        }

        return s;
    }

    public static void main(String[] args) {
        ArrayMap dictionar = new ArrayMap();
        dictionar.put("cheie1", "valoare1");
        dictionar.put(2, 22);
        dictionar.put(3, 33);
        dictionar.put("cheie4", "valoare4");
        dictionar.put("cheie5", "valoare5");
        System.out.println(dictionar);
    }
}
