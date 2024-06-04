import java.util.function.Consumer;

public class CustomStack {

    private static class Node {
        private int value;
        private Node previous;

        private Node(int value, Node previous) {
            this.value = value;
            this.previous = previous;
        }
    }

    private Node top;
    private int size;

    public void push(int value) {
        top = new Node(value, top);
        size++;
    }

    public int pop() {
        int value = top.value;
        top = top.previous;
        size--;
        return value;
    }

    public int peek() {
        return top.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = top;
        while (current != null) {
            consumer.accept(current.value);
            current = current.previous;
        }
    }
}
