import java.util.Scanner;

public class PawnWarsUpdated {

    private static final String[][] POSITIONS = {
            {"a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8"},
            {"a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7"},
            {"a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6"},
            {"a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5"},
            {"a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4"},
            {"a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3"},
            {"a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2"},
            {"a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"}
    };

    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;

        for (int row = 0; row < BOARD_SIZE; row++) {
            String line = scanner.nextLine();
            board[row] = line.toCharArray();
            if (line.contains("w")) {
                whiteRow = row;
                whiteCol = line.indexOf('w');
            } else if (line.contains("b")) {
                blackRow = row;
                blackCol = line.indexOf('b');
            }
        }

        String output = null;
        while (output == null) {
            boolean whiteCaptures = canCapture(whiteRow - 1, whiteCol, 'b', board);
            whiteRow = movePawn(-1, whiteRow, whiteCol, board, 'w');
            boolean blackCaptures = canCapture(blackRow + 1, blackCol, 'w', board);

            if (whiteCaptures) {
                output = String.format("Game over! White capture on %s.", POSITIONS[blackRow][blackCol]);
            } else if (blackCaptures) {
                output = String.format("Game over! Black capture on %s.", POSITIONS[whiteRow][whiteCol]);
            } else {
                blackRow = movePawn(+1, blackRow, blackCol, board, 'b');
            }

            if (isNotOnBoard(whiteRow - 1, whiteCol, board)) {
                output = String.format("Game over! White pawn is promoted to a queen at %s.",
                        POSITIONS[whiteRow][whiteCol]);
            } else if (isNotOnBoard(blackRow + 1, blackCol, board)) {
                output = String.format("Game over! Black pawn is promoted to a queen at %s.",
                        POSITIONS[blackRow][blackCol]);
            }
        }
        System.out.println(output);
    }

    private static boolean canCapture(int row, int col, char enemyPawn, char[][] board) {
        boolean captured = false;
        if (isOnBoard(row, col - 1, board)) {
            captured = board[row][col - 1] == enemyPawn;
        }
        if (!captured && isOnBoard(row, col + 1, board)) {
            captured = board[row][col + 1] == enemyPawn;
        }

        return captured;
    }

    private static boolean isOnBoard(int r, int c, char[][] board) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length;
    }

    private static boolean isNotOnBoard(int r, int c, char[][] board) {
        return !isOnBoard(r, c, board);
    }

    private static int movePawn(int direction, int row, int col, char[][] board, char playerPawn) {
        int nextRow = row + direction;
        board[row][col] = '-';
        board[nextRow][col] = playerPawn;
        return nextRow;
    }
}

