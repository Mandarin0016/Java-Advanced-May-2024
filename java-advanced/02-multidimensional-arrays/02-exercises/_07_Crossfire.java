import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> field = new ArrayList<>();
        initializeField(field, rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {

            int[] commandParts = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int row = commandParts[0];
            int col = commandParts[1];
            int radius = commandParts[2];

            destroyArea(field, row, col, radius);

            command = scanner.nextLine();
        }

        printMatrix(field);
    }

    private static void destroyArea(List<List<Integer>> field, int targetRow, int targetCol, int radius) {

        // Премахваме хоризонтално
        for (int col = targetCol - radius; col <= targetCol + radius; col++) {
            if (isInside(field, targetRow, col)) {
                field.get(targetRow).set(col, 0);
            }
        }

        // Премахваме вертиикално
        for (int row = targetRow - radius; row <= targetRow + radius; row++) {
            if (isInside(field, row, targetCol)) {
                field.get(row).set(targetCol, 0);
            }
        }

        for (int row = 0; row < field.size(); row++) {
            List<Integer> currentRow = field.get(row);
            currentRow.removeAll(List.of(0));
            if (currentRow.isEmpty()) {
                field.remove(row);
                row--;
            }
        }
    }

    private static boolean isInside(List<List<Integer>> field, int row, int col) {
        return row >= 0 && row < field.size() && col >= 0 && col < field.get(row).size();
    }

    private static void printMatrix(List<List<Integer>> field) {

        for (int row = 0; row < field.size(); row++) {
            field.get(row).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static void initializeField(List<List<Integer>> field, int rows, int cols) {
        int counter = 1;
        for (int row = 0; row < rows; row++) {
            ArrayList<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(counter++);
            }
            field.add(currentRow);
        }
    }
}
