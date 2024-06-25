package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillTheMatrix(rows, cols, matrix);

        long totalStars = 0;

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            int[] jediCoordinates = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // Кординати на лошият човек
            int evilRow = evilCoordinates[0];
            int evilCol = evilCoordinates[1];
            moveEvilPlayer(evilRow, evilCol, matrix);
            
            // Кординати да джедая
            int jediRow = jediCoordinates[0];
            int jediCol = jediCoordinates[1];
            totalStars = moveJediPlayerAndCollectStars(jediRow, jediCol, matrix, totalStars);

            command = scanner.nextLine();
        }

        System.out.println(totalStars);
    }

    private static long moveJediPlayerAndCollectStars(int jediRow, int jediCol, int[][] matrix, long totalStars) {

        while (jediRow >= 0 && jediCol < matrix[1].length) {
            if (jediRow < matrix.length && jediCol >= 0 && jediCol < matrix[0].length) {
                totalStars += matrix[jediRow][jediCol];
            }
            jediCol++;
            jediRow--;
        }
        return totalStars;
    }

    private static void moveEvilPlayer(int evilRow, int evilCol, int[][] matrix) {

        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < matrix.length && evilCol < matrix[0].length) {
                matrix[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void fillTheMatrix(int rows, int cols, int[][] matrix) {

        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}
