import java.util.ArrayDeque;

public class Demo {

    public static void main(String[] args) {

        // Стек
        // LIFO -> Last In, First Out
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(2);
        stack.push(15);
        stack.push(14);
        System.out.println(stack.peek());
        System.out.println(stack.pop());

        // Опашка
        // FIFO -> First In, First Out
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(2);
        queue.offer(15);
        queue.offer(14);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
    }
}
