import java.util.Iterator;

public class SmartArray<T> implements Iterable<T> {

    private static final int INITIAL_SIZE = 4;

    private Object[] elements;
    private int size;

    public SmartArray() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(T element) {
        if (!hasSpace()) {
            elements = grow();
        }
        elements[size] = element;
        size++;
    }

    public void add(int index, T element) {
        T lastElement = get(index);

        for (int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        add(lastElement);
    }

    public T remove(int index) {
        T removed = get(index);

        for (int i = index; i < size() - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = 0;
        size--;

        if (size <= elements.length / 4) {
            elements = shrink();
        }

        return removed;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < size(); i++) {
            if (element.equals(get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpace() {
        return size < elements.length;
    }

    private Object[] grow() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        return newElements;
    }

    private Object[] shrink() {
        Object[] newElements = new Object[elements.length / 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        return newElements;
    }

    private class SmartArrayIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size();
        }

        @Override
        public T next() {
            return get(index++);
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new SmartArrayIterator();
    }

}
