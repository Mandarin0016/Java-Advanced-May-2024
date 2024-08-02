import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        try {
            double sqrt = sqrt(n);
            System.out.println(String.format("%.2f", sqrt));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Goodbye");
        }

    }

    public static double sqrt(double number) {
        if (number < 0) {
            throw new ArithmeticException("Invalid");
        }
        return Math.sqrt(number);
    }
}
