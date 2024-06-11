package shelf;

import java.util.Iterator;
import java.util.List;

public class Shelf implements Iterable<String> {

    private List<String> fruits;

    public Shelf(String... fruits) {
        this.fruits = List.of(fruits);
    }

    // Iterable = нещото което се обхожда
    // Iterator = нещото което знае как да обхожда

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {

            private int index = 0;

            // Проверява дало има следващ елемент в поредицата
            @Override
            public boolean hasNext() {
                return index < fruits.size();
            }

            // Връща следващият елемент в поредицата
            @Override
            public String next() {
                String fruit = fruits.get(index);
                index++;
                return fruit;
            }
        };
    }
}
