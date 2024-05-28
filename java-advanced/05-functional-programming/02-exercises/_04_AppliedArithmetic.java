import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetic {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        Function<List<Integer>, List<Integer>> addFunction = listOfNumbers -> listOfNumbers.stream().map(number -> number + 1).toList();
        Function<List<Integer>, List<Integer>> multiplyFunction = listOfNumbers -> listOfNumbers.stream().map(number -> number * 2).toList();
        Function<List<Integer>, List<Integer>> subtractFunction = listOfNumbers -> listOfNumbers.stream().map(number -> number - 1).toList();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbers = addFunction.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyFunction.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtractFunction.apply(numbers);
                    break;
                case "print":
                    numbers.forEach(number -> System.out.print(number + " "));
                    System.out.println();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
