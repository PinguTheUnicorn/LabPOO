import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T value;
        Node <T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    class ListIterator implements Iterator<T> {
        private Node<T> currentNode;

        public ListIterator(Node<T> node) {
            currentNode = node;
        }

        public boolean hasNext() {
            return (currentNode != null);
        }

        public T next() {
            T value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public T getNode() {
        return first.value;
    }

    public void addFirst(T value) {
        if(first == null) {
            first = new Node(value);
            last = first;
            return;
        }

        first = new Node(value, first);
    }

    public void add(T value) {
        if(first == null) {
            first = new Node(value);
            last = first;
            return;
        }

        last.next = new Node(value);
        last = last.next;
    }

    public Iterator<T> iterator() {
        return new ListIterator(first);
    }
}
