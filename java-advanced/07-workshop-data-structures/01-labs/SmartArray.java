import java.util.function.Consumer;

public class SmartArray {

    private static final int INITIAL_SIZE = 4;

    private int[] elements;
    private int size;

    public SmartArray() {
        this.elements = new int[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(int element) {
        if (!hasSpace()) {
            elements = grow();
        }
        elements[size] = element;
        size++;
    }

    public void add(int index, int element) {
        int lastElement = elements[size - 1];

        for (int i = size - 1; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        add(lastElement);
    }

    public int remove(int index) {
        int removed = elements[index];

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

    public int get(int index) {
        return elements[index];
    }

    public int size() {
        return size;
    }

    public boolean contains(int element) {
        for (int i = 0; i < size(); i++) {
            if (element == elements[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean hasSpace() {
        return size < elements.length;
    }

    private int[] grow() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        return newElements;
    }

    private int[] shrink() {
        int[] newElements = new int[elements.length / 2];
        System.arraycopy(elements, 0, newElements, 0, size);
        return newElements;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size(); i++) {
            consumer.accept(elements[i]);
        }
    }
}
