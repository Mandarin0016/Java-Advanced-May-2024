import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Demo {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        Stream<Integer> integerStream = list.stream()
                .filter(e -> {
                    System.out.println("Predicate checking: " + e);
                    return e % 2 == 0;
                })
                .map(e -> {
                    System.out.println("Mapping: " + e);
                    return e * 2;
                })
                .map(e -> {
                    System.out.println("Second Mapper: " + e);
                    return e;
                });


        System.out.println("Last line in code");

        List<Integer> ignoredList = integerStream
                .toList();
    }
}
