import java.util.function.Consumer;

public class CustomStack<T> {

    private record Node<T>(T value, CustomStack.Node<T> previous) {
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

    public void forEach(Consumer<T> consumer) {
        Node<T> current = top;
        while (current != null) {
            consumer.accept(current.value);
            current = current.previous;
        }
    }
}
