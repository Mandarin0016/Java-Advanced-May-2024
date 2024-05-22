import java.util.*;

public class Demo_3 {

    public static void main(String[] args) {

        // new HashSet<>()       -> не пази конкретна подредба на елементите
        // new TreeSet<>()       -> запазва елементите в нарастващ ред
        // new LinkedHashSet<>() -> запазва елементите в реда на тяхно добавяне
        Set<Integer> numbers = new LinkedHashSet<>();

        // ВАЖНО: Сет -> Пази само уникални елементи
        // ВАЖНО: Сет -> Не може да достъпваме елементи по индекс
        numbers.add(4);
        numbers.add(5);
        numbers.add(4);

        System.out.println(numbers.size()); // 2

        System.out.println(numbers.contains(5)); // true
    }
}
