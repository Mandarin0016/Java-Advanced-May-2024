package collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {

    private int index;
    private final List<String> data;

    public ListyIterator(List<String> data) {
        this.data = data;
    }

    public void printAll() {
        validatePrint();
        this.data.forEach(e -> System.out.printf("%s ", e));
        System.out.println();
    }


    public void print() {
        validatePrint();
        System.out.println(this.data.get(index));
    }

    private void validatePrint() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    public boolean move() {
        if (iterator().hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return index < data.size() - 1;
            }

            @Override
            public String next() {
                String element = data.get(index);
                index++;
                return element;
            }
        };
    }
}
