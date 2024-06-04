import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {

    private Element head;
    private Element tail;
    private int size;

    public int[] toArray() {

        List<Integer> numbers = new ArrayList<>();
        this.forEach(value -> numbers.add(value));
        return numbers.stream().mapToInt(Integer::intValue).toArray();
    }

    public void forEach(Consumer<Integer> consumer) {

        Element currentElement = this.head;
        while (currentElement != null) {
            consumer.accept(currentElement.value);
            currentElement = currentElement.next;
        }
    }

    public int removeLast() {

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }

        int result = this.tail.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return result;
    }

    public int removeFirst() {

        if (this.isEmpty()) {
            throw new NoSuchElementException("The list is empty.");
        }

        int result = this.head.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return result;
    }

    public int get(int index) {

        if (!isValidIndex(index)) {
            throw new IndexOutOfBoundsException("You are giving invalid index.");
        }

        Element currentElement = this.head;
        for (int position = 0; position < index; position++) {
            currentElement = currentElement.next;
        }
        return currentElement.value;
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < this.size;
    }

    public void addLast(int elementValue) {

        if (this.isEmpty()) {
            addIfEmpty(elementValue);
        } else {
            Element newElement = new Element(elementValue, this.tail, null);
            this.tail.next = newElement;
            this.tail = newElement;
        }
        this.size++;
    }

    public void addFirst(int elementValue) {

        if (this.isEmpty()) {
            addIfEmpty(elementValue);
        } else {
            Element newElement = new Element(elementValue, null, this.head);
            this.head.prev = newElement;
            this.head = newElement;
        }
        this.size++;
    }

    private void addIfEmpty(int elementValue) {
        Element newElement = new Element(elementValue, null, null);
        this.head = newElement;
        this.tail = newElement;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
