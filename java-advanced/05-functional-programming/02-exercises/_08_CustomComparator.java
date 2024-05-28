import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class _08_CustomComparator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toList();

        // Comparator: Ламбда израз, приема 2 аргумента и връща цяло число (-1, 0, 1)
        // sorted(-1) = няма да има размяна
        // sorted(0) = няма да има размяна
        // sorted(1) = ще размени елементиите
        Comparator<Integer> comparator = (first, second) -> {
            // първото-нечетно, второто-четно -> разменям числата
            if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            }
            // първото-четно, второто-нечетно -> не разменям числата
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            }

            // първото-четно, второто-четно
            // първото-нечетно, второто-нечетно
            // Default Comparator Implementation за числа: Подрежда числата в нарастващ ред
            // първото > второто = 1
            // първото < второто = -1
            // първото == второто = 0
            return first.compareTo(second);
        };

        numbers.stream().sorted(comparator).forEach(number -> System.out.print(number + " "));
    }
}
