import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _09_ListOfPredicates {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisors = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Predicate<Integer>> predicates = new ArrayList<>();
        for (Integer divisor : divisors) {
            // num -> num % divisor == 0
            Predicate<Integer> predicate = num -> num % divisor == 0;
            predicates.add(predicate);
        }

        for (int number = 1; number <= n; number++) {
            boolean isDivisibleInAllPredicates = true;
            for (Predicate<Integer> predicate : predicates) {
                if (!predicate.test(number)) {
                    isDivisibleInAllPredicates = false;
                }
            }
            if (isDivisibleInAllPredicates){
                System.out.print(number + " ");
            }
        }
    }
}
