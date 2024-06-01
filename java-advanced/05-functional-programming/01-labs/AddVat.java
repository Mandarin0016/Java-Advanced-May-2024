import java.util.Arrays;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Prices with VAT:");

        DoubleUnaryOperator addVat = v -> v * 1.2;

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVat)
                .forEach(v -> System.out.printf("%.2f%n", v));
    }
}
