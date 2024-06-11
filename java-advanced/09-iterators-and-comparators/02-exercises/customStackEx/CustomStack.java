package customStackEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomStack implements Iterable<Integer> {

    private List<Integer> numbers;

    public CustomStack() {
        this.numbers = new ArrayList<>();
    }

    public int pop() {
        if (numbers.isEmpty()) {
            System.out.println("No elements");
            return 0;
        } else {
            int number = numbers.get(this.numbers.size() - 1);
            numbers.remove(this.numbers.size() - 1);
            return number;
        }
    }

    public void push(int number) {
        numbers.add(number);
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            private int index = numbers.size() - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                int number = numbers.get(index);
                index--;
                return number;
            }
        };
    }
}
