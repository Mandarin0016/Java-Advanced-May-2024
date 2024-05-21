import java.util.Scanner;

public class _01_FillTheMatrix {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // "3, A"
        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1]; //"A" или "B"

        int[][] matrix = new int[n][n];

        // 1. Проверяваме шаблона
        // 2. Извиикваме правиилният метод
        switch (pattern) {
            case "A" -> fillMatrixPatternA(matrix);
            case "B" -> fillMatrixPatternB(matrix);
        }

        // 3. Отпечатваме матрицата
        printMatrix(matrix);
    }

    private static void fillMatrixPatternB(int[][] matrix) {

        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {

            // Ако колоната е четно число: 0 ред до последен
            if (col % 2 == 0) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = counter++;
                }
            }
            // Ако колоната е нечетно число: последен до 0 ред
            else {
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = counter++;
                }
            }
        }
    }

    private static void fillMatrixPatternA(int[][] matrix) {

        int counter = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = counter++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
