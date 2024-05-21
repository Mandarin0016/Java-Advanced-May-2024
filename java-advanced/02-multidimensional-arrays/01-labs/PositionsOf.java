import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int arrays = input[0];
        int elementsPerArray = input[1];

        int[][] matrix = new int[arrays][elementsPerArray];

        for (int i = 0; i < arrays; i++) {
            int[] currentArr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = currentArr;
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            for (int j = 0; j < arr.length; j++) {
                int n = arr[j];
                if (n == number) {
                    output.add(i + " " + j);
                }
            }
        }

        if (output.isEmpty()) {
            output.add("not found");
        }

        System.out.println(String.join(System.lineSeparator(), output));
    }
}
