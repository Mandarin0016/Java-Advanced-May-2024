import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];
        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            if (!isValidCommand(command, matrix)) {
                System.out.println("Invalid input!");
            } else {

                // 1. Сменяме елементите
                String[] commandElements = command.split(" ");
                int firstRow = Integer.parseInt(commandElements[1]);
                int firstCol = Integer.parseInt(commandElements[2]);
                int secondRow = Integer.parseInt(commandElements[3]);
                int secondCol = Integer.parseInt(commandElements[4]);

                String temp = matrix[firstRow][firstCol];
                matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                matrix[secondRow][secondCol] = temp;

                // 2. Отпечатваме матрицата
                printMatrix(matrix);
            }

            command = scanner.nextLine();
        }

        System.out.println();
    }

    private static void printMatrix(String[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValidCommand(String command, String[][] matrix) {

        //swap 0 0 1 1
        String[] commandElements = command.split(" ");
        if (commandElements.length != 5 || !commandElements[0].equals("swap")) {
            return false;
        }

        int firstRow = Integer.parseInt(commandElements[1]);
        int firstCol = Integer.parseInt(commandElements[2]);
        int secondRow = Integer.parseInt(commandElements[3]);
        int secondCol = Integer.parseInt(commandElements[4]);

        boolean isValidRow = isValidRow(firstRow, matrix) && isValidRow(secondRow, matrix);
        boolean isValidCol = isValidCol(firstCol, matrix) && isValidCol(secondCol, matrix);

        return isValidRow && isValidCol;
    }

    private static boolean isValidRow(int rowIndex, String[][] matrix) {
        return rowIndex >= 0 && rowIndex < matrix.length;
    }

    private static boolean isValidCol(int colIndex, String[][] matrix) {
        return colIndex >= 0 && colIndex < matrix[0].length;
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrix[row] = currentRow;
        }
    }
}
