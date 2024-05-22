import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = firstMatrix.length == secondMatrix.length;

        int i = 0;
        while (i < firstMatrix.length && areEqual) {
            int[] firstArr = firstMatrix[i];
            int[] secondArr = secondMatrix[i];
            areEqual = firstArr.length == secondArr.length;

            int j = 0;
            while (j < firstArr.length && areEqual) {
                areEqual = firstArr[j] == secondArr[j];
                j++;
            }
            i++;
        }

        String output = areEqual ? "equal" : "not equal";
        System.out.println(output);
    }

    public static int[][] readMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);

        int arrays = dimensions[0];
        int elementsPerArray = dimensions[1];

        int[][] matrix = new int[arrays][elementsPerArray];

        for (int i = 0; i < arrays; i++) {
            matrix[i] = readArray(scanner);
        }

        return matrix;
    }

    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
