import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Demo_05 {

    public static void main(String[] args) {

        // Imperative/Structured way of programming
        List<String> names = Arrays.asList("Ivan", "Gosho", "Tosho", "Ivana");
        for (String name : names) {
            if (name.startsWith("I")) {
                System.out.println(name);
            }
        }

        // Functional way of programming (Using Lambda expression)
        names.stream()
                .filter(name -> name.startsWith("I")) // Predicate
                .map(name -> name.toUpperCase()) // Function
                .forEach(name -> System.out.println(name));// Consumer (terminal operation)

        Supplier<Integer> aRandomNumber = () -> new Random().nextInt();
        System.out.println(aRandomNumber.get());
        BiFunction<String, String, String> concatenateBiFunction = (name1, name2) -> name1 + " " + name2;
        System.out.println(concatenateBiFunction.apply("Viktor", "Aleksandrov"));
        // Predicate: аргумент -> израз/действие, който връща булева стойност
        // Consumer: аргумент -> извършва се действие без да се връща резултата
        // Function: аргумент -> извършва се действие с този аргумент и връща резултат
        // Supplier: () -> извършва действие и връща резултат
        // BiFunction: (аргумент1, аргумент2) -> извършва се действие с тези два аргумента и връща резултат

        Scanner scanner = new Scanner(System.in);
        int[] numbers1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> numbers2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList();
    }
}
