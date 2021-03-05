import java.util.*;

public class LinkedSet extends LinkedList implements Set {
    public boolean add(Object obj) {
        if(!contains(obj)) {
            super.add(obj);
            return true;
        } else
            return false;
    }

    public void add(int index, Object obj) {
        super.add(index, obj);
    }

    public Object set(int index, Object obj) {
        return super.set(index, obj);
    }
}
