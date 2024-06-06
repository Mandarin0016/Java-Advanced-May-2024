import java.util.ArrayList;
import java.util.List;

public class Main {

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Person {
    }

    public static void main(String[] args) {
//        Scale<Cat> catScale = new Scale<>(new Cat(), new Cat());
        Scale<Integer> integerScale = new Scale<>(13, 42);
        System.out.println(integerScale.getHeavier());
        Scale<String> stringScale = new Scale<>("bbbb", "aaaa");
        System.out.println(stringScale.getHeavier());


        List<Integer> numbers = new ArrayList<>();
        numbers.add(13);
        numbers.add(42);
        numbers.add(69);
        numbers.add(3);
        numbers.add(73);

        System.out.println(ListUtils.getMin(numbers));
    }
}
