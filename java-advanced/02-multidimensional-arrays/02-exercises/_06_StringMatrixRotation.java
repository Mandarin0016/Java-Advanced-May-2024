import java.util.*;

public class _06_StringMatrixRotation {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 90, 180, 360
        String rotationAngle = scanner.nextLine().replace("Rotate(", "").replace(")", "");
        int rotationTimes = Integer.parseInt(rotationAngle) / 90;

        List<String> words = new ArrayList<>();
        String word = scanner.nextLine();
        while (!word.equals("END")) {
            words.add(word);
            word = scanner.nextLine();
        }

        int rows = words.size();
        int cols = Collections.max(words, Comparator.comparing(String::length)).length();
        char[][] matrix = new char[rows][cols];

        fillMatrix(matrix, words);

        for (int rotation = 1; rotation <= rotationTimes; rotation++) {
            matrix = rotateMatrix90(matrix);
        }

        printMatrix(matrix);
    }

    private static char[][] rotateMatrix90(char[][] oldMatrix) {

        // Редовете == броя на колониите на първият ред от старата матрица
        // Колоните == броя на редовете от старата матрица
        int newRows = oldMatrix[0].length;
        int newCols = oldMatrix.length;
        char[][] newMatrix = new char[newRows][newCols];

        // Обхождам СТАРАТА матрица и местя елементите в НОВАТА!
        // Колона: 0 към последна
        // Ред: последн към 0
        for (int col = 0; col < oldMatrix[0].length; col++) {
            int counter = 0;
            for (int row = oldMatrix.length - 1; row >= 0; row--) {
                char symbol = oldMatrix[row][col];
                newMatrix[col][counter] = symbol;
                counter++;
            }
        }

        return newMatrix;
    }

    private static void fillMatrix(char[][] matrix, List<String> words) {

        for (int row = 0; row < matrix.length; row++) {
            String word = words.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if (col <= word.length() - 1) {
                    matrix[row][col] = word.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }

}
