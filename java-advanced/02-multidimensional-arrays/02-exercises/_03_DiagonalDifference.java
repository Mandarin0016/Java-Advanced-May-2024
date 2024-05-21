import java.util.Scanner;

public class _03_DiagonalDifference {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];

        // 1. Прочиитаме матрицата от конозлата
        fillTheMatrix(matrix, scanner);

        // 2. Намираме сумата на главният диагонал
        int primaryDiagonalSum = getPrimaryDiagonalSum(matrix);

        // 3. Намираме сумата на второстепенният диагонал
        int secondaryDiagonalSum = getSecondaryDiagonalSum(matrix);

        // 4. Отпечатваме абсолютната стойност на разликата на двете суми
        System.out.println(Math.abs(primaryDiagonalSum - secondaryDiagonalSum));
    }

    private static int getPrimaryDiagonalSum(int[][] matrix) {

        int sum = 0;

        // Локациията е: индекс на реда == индекс на колона
        for (int index = 0; index < matrix.length; index++) {
            int num = matrix[index][index];
            sum += num;
        }

        return sum;
    }

    private static int getSecondaryDiagonalSum(int[][] matrix) {

        int sum = 0;

        // Ред: от последен към 0
        // Колона: 0 докато има редове (всеки път +1)
        int col = 0;
        for (int row = matrix.length - 1; row >= 0; row--) {
            int num = matrix[row][col];
            sum += num;
            col++;
        }

        return sum;
    }

    private static void fillTheMatrix(int[][] matrix, Scanner scanner) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
