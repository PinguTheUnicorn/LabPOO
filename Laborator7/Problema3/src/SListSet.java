import java.util.*;

public class SListSet extends LinkedList implements SortedSet {
    private Comparator comparator;

    @Override
    public Comparator comparator() {
        return comparator;
    }

    public SListSet() {
        comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return o1.toString().compareTo(o2.toString());
            }
        };
    }

    public SListSet(Comparator c) {
        comparator = c;
    }

    public boolean add(Object obj) {
        if(!contains(obj)) {
            super.add(obj);
            Collections.sort(this, comparator());
            return true;
        } else
            return false;
    }

    public Object first() {
        return getFirst();
    }

    public Object last() {
        return getLast();
    }

    public SortedSet subSet(Object from, Object to) {
        SortedSet set = new SListSet();
        int m = (int) from;
        int n = (int) to;

        for(int i = m; i <= n; i++) {
            set.add(this.get(i));
        }

        return set;
    }

    public SortedSet headSet(Object to) {
        return subSet(0, to);
    }

    public SortedSet tailSet(Object from) {
        return subSet(from, lastIndexOf(last()));
    }
}
