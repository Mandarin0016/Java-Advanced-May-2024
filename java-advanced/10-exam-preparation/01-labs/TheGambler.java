import java.util.Scanner;

public class TheGambler {

    private static int money = 100;
    private static boolean isJackpotWinner = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] board = new char[size][size];

        int row = 0, col = 0;

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            board[r] = line.toCharArray();
            if (line.contains("G")) {
                row = r;
                col = line.indexOf("G");
            }
        }

        String direction = scanner.nextLine();

        while (!direction.equals("end") && money > 0 && !isJackpotWinner) {
            if (direction.equals("up")) {
                movePlayer(row, col, row - 1, col, board);
                row--;
            } else if (direction.equals("down")) {
                movePlayer(row, col, row + 1, col, board);
                row++;
            } else if (direction.equals("left")) {
                movePlayer(row, col, row, col - 1, board);
                col--;
            } else {
                movePlayer(row, col, row, col + 1, board);
                col++;
            }

            direction = scanner.nextLine();
        }

        if (money <= 0) {
            System.out.println("Game over! You lost everything!");
        } else {
            if (isJackpotWinner) {
                System.out.println("You win the Jackpot!");
            }
            System.out.println("End of the game. Total amount: " + money + "$");
            printBoard(board);
        }

    }

    private static void movePlayer(int row, int col, int nextRow, int nextCol, char[][] board) {
        if (!isInBounds(nextRow, nextCol, board)) {
            money = -1;
            return;
        }

        char nextPosSymbol = board[nextRow][nextCol];

        if (nextPosSymbol == 'W') {
            money += 100;
        } else if (nextPosSymbol == 'P') {
            money -= 200;
        } else if (nextPosSymbol == 'J') {
            money += 100000;
            isJackpotWinner = true;
        }

        board[row][col] = '-';
        board[nextRow][nextCol] = 'G';
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static int amountToAdd(char symbol) {
        return switch (symbol) {
            case 'W' -> 100;
            case 'P' -> -200;
            case 'J' -> 100000;
            default -> 0;
        };
    }

    public static boolean isInBounds(int r, int c, char[][] board) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length;
    }
}
