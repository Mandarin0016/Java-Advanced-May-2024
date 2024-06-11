package froggy;

import java.util.Iterator;
import java.util.List;

// Iterable<тип на елемента, който ще обхождам в това езеро>
public class Lake implements Iterable<Integer> {

    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    // Това е нашата Жаба
    @Override
    public Iterator<Integer> iterator() {

        return new Iterator<Integer>() {

            private int evenIndex = 0;
            private int oddIndex = 1;

            // Ако не съм стигнал до края с един от двата индекса -> все още имаме числа в езерото
            @Override
            public boolean hasNext() {
                return evenIndex < numbers.size() || oddIndex < numbers.size();
            }

            @Override
            public Integer next() {

                int number;
                if (evenIndex < numbers.size()) {
                    number = numbers.get(evenIndex);
                    evenIndex += 2;
                } else {
                    number = numbers.get(oddIndex);
                    oddIndex += 2;
                }
                return number;
            }
        };
    }
}
