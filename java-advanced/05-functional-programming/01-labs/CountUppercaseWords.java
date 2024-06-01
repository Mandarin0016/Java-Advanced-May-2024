import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUppercase =
                s -> Character.isUpperCase(s.charAt(0));

        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(startsWithUppercase)
                .toList();

        Consumer<String> printer = System.out::println;

        System.out.println(list.size());
        list.forEach(printer);
    }
}
