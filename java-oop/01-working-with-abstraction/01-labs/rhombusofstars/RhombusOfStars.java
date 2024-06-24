package rhombusofstars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        printTopPart(size);
        printBottomPart(size);
    }

    private static void printBottomPart(int size) {
        for (int r = 1; r < size; r++) {
            printRepeatingString(" ", r);
            printRepeatingString("* ", size - r);
            System.out.println();
        }
    }

    private static void printTopPart(int n) {
        for (int r = 1; r <= n; r++) {
            printRepeatingString(" ", n - r);
            printRepeatingString("* ", r);
            System.out.println();
        }
    }

    private static void printRepeatingString(String str, int repetitions) {
        for (int i = 0; i < repetitions; i++) {
            System.out.print(str);
        }
    }
}
