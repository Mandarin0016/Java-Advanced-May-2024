package listyIterator;

import java.util.List;

public class ListyIterator {

    private int index;
    private final List<String> elements;

    public ListyIterator(List<String> data) {
        this.elements = data;
    }

    public void print() {
        validatePrint();
        System.out.println(this.elements.get(index));
    }

    private void validatePrint() {
        if (this.elements.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index < elements.size() - 1;
    }
}
