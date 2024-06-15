import java.util.Scanner;

public class PawnWars {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] board = new char[8][8];

        int whiteRow = 0;
        int whiteCol = 0;
        int blackRow = 0;
        int blackCol = 0;

        for (int row = 0; row < 8; row++) {
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

        boolean isPlaying = true;
        while (isPlaying) {
            boolean whiteCanCapture =
                    movePawn(-1, whiteRow, whiteCol, board, 'b');

            if (whiteCanCapture) {
                System.out.printf("Game over! White capture on %s.", POSITIONS[blackRow][blackCol]);
                isPlaying = false;
            } else {
                board[whiteRow][whiteCol] = '-';
                whiteRow--;
                board[whiteRow][whiteCol] = 'w';
                if (whiteRow == 0) {
                    System.out.printf("Game over! White pawn is promoted to a queen at %s.",
                            POSITIONS[whiteRow][whiteCol]);
                    isPlaying = false;
                }
            }

            if (isPlaying) {
                boolean blackCanCapture = movePawn(1, blackRow, blackCol, board, 'w');

                if (blackCanCapture) {
                    System.out.printf("Game over! Black capture on %s.", POSITIONS[whiteRow][whiteCol]);
                    isPlaying = false;
                } else {
                    board[blackRow][blackCol] = '-';
                    blackRow++;
                    board[blackRow][blackCol] = 'b';
                    if (blackRow == 7) {
                        System.out.printf("Game over! Black pawn is promoted to a queen at %s.",
                                POSITIONS[blackRow][blackCol]);
                        isPlaying = false;
                    }
                }
            }
        }
    }

    private static boolean isOnBoard(int r, int c, char[][] board) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length;
    }

    private static boolean movePawn(int direction, int row, int col,
                                    char[][] board, char enemyPawn) {
        boolean canCapture = false;
        int nextRow = row + direction;
        if (isOnBoard(nextRow, col - 1, board)) {
            canCapture = board[nextRow][col - 1] == enemyPawn;
        }
        if (!canCapture && isOnBoard(nextRow, col + 1, board)) {
            canCapture = board[nextRow][col + 1] == enemyPawn;
        }

        return canCapture;
    }
}
