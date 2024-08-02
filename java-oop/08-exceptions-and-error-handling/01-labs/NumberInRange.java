import java.util.Arrays;
import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        System.out.printf("Range: [%d...%d]%n", begin, end);

        boolean isWithinRange = false;

        int n = 0;

        while (!isWithinRange) {
            String line = scanner.nextLine();

            try {
                n = Integer.parseInt(line);
                isWithinRange = n >= begin && n <= end;
            } catch (NumberFormatException ignored) {
            }

            if (!isWithinRange) {
                System.out.println("Invalid number: " + line);
            }
        }

        System.out.println("Valid number: " + n);
    }

    public static boolean isNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
