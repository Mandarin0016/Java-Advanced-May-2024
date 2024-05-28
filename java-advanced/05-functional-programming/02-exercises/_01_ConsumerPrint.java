import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class _01_ConsumerPrint {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).toList();

        // Consumer: аргумент -> извършва се действие без да се връща резултата
        Consumer<String> consumer = name -> System.out.println(name);
        // Начин 1:
//        for (String name : names) {
//            consumer.accept(name);
//        }

        // Начин 2:
        names.forEach(consumer);

        // Начин 3:
//        names.forEach(name -> System.out.println(name));
    }
}
