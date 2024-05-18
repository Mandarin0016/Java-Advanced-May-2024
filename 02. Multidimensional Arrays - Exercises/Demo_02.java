import java.util.Arrays;
import java.util.Scanner;

public class Demo_02 {

    public static void main(String[] args) {

        // 1. Какво е матрица?
        int[][] matrix = new int[4][4];

        // 2. Как се обхожда матрица?
        // matrix.length -> броят на редовете
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

        // 3. Как се прочита матрица от конзолата?
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rowNumber = input[0];
        int colNumber = input[1];

        int[][] matrix2 = new int[rowNumber][colNumber];

        // ВАРИАНТ 1:
        for (int row = 0; row < rowNumber; row++) {
            for (int col = 0; col < colNumber; col++) {
                matrix2[row][col] = scanner.nextInt();
            }
        }

        // ВАРИАНТ 2:
        for (int row = 0; row < rowNumber; row++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix2[row] = currentRow;
        }

        // 4. Валидация на индекс.

        int rowIndex = Integer.parseInt(scanner.nextLine());
        int colIndex = Integer.parseInt(scanner.nextLine());

        // Валиден индекс за ред: индекс >= 0 && индекс < броят на редовете в матрицата(matrix.length)
        // Невалиден индекс за ред: индекс < 0 || индекс >= броят на редовете в матрицата(matrix.length)
        if (rowIndex < 0 || rowIndex >= matrix2.length) {
            System.out.println("Invalid index for row!");
            return;
        }

        // Валиден индекс за колона: индекс >= 0 && индекс < дължината на реда(matrix[row].length)
        // Невалиден индекс за колона: индекс < 0 || индекс >= дължината на реда(matrix[row].length)
        if (colIndex < 0 || colIndex >= matrix2[rowIndex].length) {
            System.out.println("Invalid index for col!");
            return;
        }

        System.out.println(matrix2[rowIndex][colIndex]);
    }
}
