import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int[] arr = readArray(scanner);

        int wrongValue = matrix[arr[0]][arr[1]];

        List<int[]> correctedValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int correctValue = 0;

                    // UP
                    if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != wrongValue) {
                        correctValue += matrix[r - 1][c];
                    }
                    // LEFT
                    if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != wrongValue) {
                        correctValue += matrix[r][c - 1];
                    }
                    // DOWN
                    if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != wrongValue) {
                        correctValue += matrix[r + 1][c];
                    }
                    // RIGHT
                    if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != wrongValue) {
                        correctValue += matrix[r][c + 1];
                    }

                    int[] indexesAndCorrectValue = new int[3];
                    indexesAndCorrectValue[0] = r;
                    indexesAndCorrectValue[1] = c;
                    indexesAndCorrectValue[2] = correctValue;

                    correctedValues.add(indexesAndCorrectValue);
                }
            }
        }

        for (int[] params : correctedValues) {
            matrix[params[0]][params[1]] = params[2];
        }

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {

        for (int[] arr : matrix) {
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length
                && c >= 0 && c < matrix[r].length;
    }


    private static int[][] readMatrix(Scanner scanner) {

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int r = 0; r < size; r++) {
            matrix[r] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
