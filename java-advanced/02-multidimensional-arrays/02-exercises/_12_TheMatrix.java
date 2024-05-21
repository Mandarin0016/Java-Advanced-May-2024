import java.util.Arrays;
import java.util.Scanner;

public class _12_TheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = size[0];
        int cols = size[1];

        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, scanner);

        printMatrix(matrix, scanner);
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static void printMatrix(char[][] matrix, Scanner scanner) {

        char symbol = scanner.nextLine().charAt(0);

        int[] positions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int startRow = positions[0];
        int startCol = positions[1];

        char oldSymbol = matrix[startRow][startCol];

        fill(matrix, startRow, startCol, symbol, oldSymbol);

        printMatrix(matrix);
    }

    private static void fill(char[][] matrix, int startRow, int startCol, char symbol, char oldSymbol) {

        if (matrix[startRow][startCol] != oldSymbol) {
            return;
        }

        matrix[startRow][startCol] = symbol;

        if (startRow + 1 < matrix.length) {
            fill(matrix, startRow + 1, startCol, symbol, oldSymbol);
        }

        if (startRow - 1 >= 0) {
            fill(matrix, startRow - 1, startCol, symbol, oldSymbol);
        }

        if (startCol + 1 < matrix[startRow].length) {
            fill(matrix, startRow, startCol + 1, symbol, oldSymbol);
        }

        if (startCol - 1 >= 0) {
            fill(matrix, startRow, startCol - 1, symbol, oldSymbol);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                System.out.print(matrix[rows][cols]);
            }
            System.out.println();
        }
    }
}
