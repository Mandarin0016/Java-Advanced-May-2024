import java.util.Arrays;
import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("Count = " + arr.length);
        System.out.println("Sum = " + Arrays.stream(arr).sum());
    }
}
