import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(matrix, scanner);

        int[] myCoordinates = findMyPosition(matrix);
        int myRow = myCoordinates[0];
        int myCol = myCoordinates[1];

        int totalFishCollected = 0;

        String movement = scanner.nextLine(); //"up", "down", "left", and "right".
        while (!movement.equals("collect the nets")) {

            matrix[myRow][myCol] = '-';
            switch (movement) {
                case "up" -> myRow--;
                case "down" -> myRow++;
                case "left" -> myCol--;
                case "right" -> myCol++;
            }

            // реда < 0             |  реда = последният ред
            // реда > последният    |  реда = 0
            // колона < 0           |  колона = последната колона
            // колона > последната  |  колона = 0
            if (myRow < 0) {
                myRow = matrix.length - 1;
            } else if (myRow > matrix.length - 1) {
                myRow = 0;
            }
            if (myCol < 0) {
                myCol = matrix.length - 1;
            } else if (myCol > matrix.length - 1) {
                myCol = 0;
            }

            if (Character.isDigit(matrix[myRow][myCol])) {
                totalFishCollected += Integer.parseInt(matrix[myRow][myCol] + "");
                matrix[myRow][myCol] = '-';
            } else if (matrix[myRow][myCol] == 'W') {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]", myRow, myCol);
                return;
            }

            matrix[myRow][myCol] = 'S';
            movement = scanner.nextLine();
        }

        if (totalFishCollected >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf("You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - totalFishCollected);
        }

        if (totalFishCollected > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", totalFishCollected);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int[] findMyPosition(char[][] matrix) {

        int[] myCoordinates = new int[2];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'S') {
                    myCoordinates[0] = row;
                    myCoordinates[1] = col;
                }
            }
        }
        return myCoordinates;
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
    }
}
