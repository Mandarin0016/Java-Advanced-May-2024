import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = 1;
        int end = 100;

        ArrayList<Integer> numbers = new ArrayList<>();

        while (numbers.size() != 10) {
            try {
                start = readNumber(start, end, scanner);
                numbers.add(start);
            } catch (NumberRangeException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    private static int readNumber(int start, int end, Scanner scanner) {
        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberRangeException("Invalid Number!", e);
        }

        if (start >= number) {
            throw new NumberRangeException("Your number is not in range " + start + " - 100!");
        }

        return number;
    }
}
