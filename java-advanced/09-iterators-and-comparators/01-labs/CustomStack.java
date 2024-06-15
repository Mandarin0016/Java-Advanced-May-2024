import java.util.Iterator;

public class CustomStack<T> implements Iterable<T> {

    private record Node<T>(T value, Node<T> previous) {
    }

    private Node<T> top;
    private int size;

    public void push(T value) {
        top = new Node<>(value, top);
        size++;
    }

    public T pop() {
        T value = top.value;
        top = top.previous;
        size--;
        return value;
    }

    public T peek() {
        return top.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private class StackIterator implements Iterator<T> {

        private Node<T> current = top;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.previous;
            return value;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

}
