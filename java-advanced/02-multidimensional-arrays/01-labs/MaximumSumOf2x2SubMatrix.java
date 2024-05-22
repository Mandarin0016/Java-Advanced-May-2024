import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            matrix[r] = readArray(scanner);
        }

        int maxSum = Integer.MIN_VALUE;

        int[][] maxMatrix = new int[2][2];

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int top = matrix[r][c];
                int right = matrix[r][c + 1];
                int bottom = matrix[r + 1][c];
                int bottomRight = matrix[r + 1][c + 1];

                int sum = top + right + bottom + bottomRight;

                if (sum > maxSum) {
                    maxSum = sum;
                    maxMatrix[0][0] = top;
                    maxMatrix[0][1] = right;
                    maxMatrix[1][0] = bottom;
                    maxMatrix[1][1] = bottomRight;
                }
            }
        }

        for (int[] arr : maxMatrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        System.out.println(maxSum);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
