import java.util.Scanner;

public class FindTheRealQueen {

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = readMatrix(scanner);
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'q' && isValidQueen(board, row, col)) {
                    System.out.println(row + " " + col);
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] board, int row, int col) {
        return
                // UP
                traverseDirection(board, row, col, -1, 0)
                // DOWN
                &&  traverseDirection(board, row, col, +1, 0)
                // LEFT
                        && traverseDirection(board, row, col, 0, -1)
                // RIGHT
                        && traverseDirection(board, row, col, 0, +1)
                // UP-LEFT
                        && traverseDirection(board, row, col, -1, -1)
                // UP-RIGHT
                        && traverseDirection(board, row, col, -1, +1)
                // DOWN-RIGHT
                        && traverseDirection(board, row, col, +1, +1)
                // DOWN-LEFT
                        && traverseDirection(board, row, col, +1, -1);
    }

    private static boolean traverseDirection(char[][] board, int row, int col, int rowDirection, int colDirection) {
        row += rowDirection;
        col += colDirection;
        while (isWithinArray(board, row, col)) {
            if ('q' == board[row][col]) {
                return false;
            }
            row += rowDirection;
            col += colDirection;
        }
        return true;
    }

    private static boolean isWithinArray(char[][] board, int currentRow, int currentCol) {
        return currentRow >= 0
                && currentRow < board.length
                && currentCol >= 0
                && currentCol < board[currentRow].length;
    }

    private static char[][] readMatrix(Scanner scanner) {
        char[][] matrix = new char[BOARD_SIZE][];
        for (int row = 0; row < BOARD_SIZE; row++) {
            String line = scanner.nextLine();
            String strippedSpaces = line.replaceAll("\\s+", "");
            matrix[row] = strippedSpaces.toCharArray();
        }
        return matrix;
    }
}
