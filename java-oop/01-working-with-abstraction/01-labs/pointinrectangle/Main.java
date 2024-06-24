package pointinrectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Rectangle rect = parseRectangle(scanner.nextLine());

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            Point p = parsePoint(scanner.nextLine());
            boolean contains = rect.contains(p);
            System.out.println(contains);
        }
    }

    public static Point parsePoint(String str) {
        int[] coordinates = parseArr(str);

        return new Point(coordinates[0], coordinates[1]);
    }

    public static Rectangle parseRectangle(String str) {
        int[] coordinates = parseArr(str);

        Point a = new Point(coordinates[0], coordinates[1]);
        Point b = new Point(coordinates[2], coordinates[3]);

        return new Rectangle(a, b);
    }

    public static int[] parseArr(String str) {
        return Arrays.stream(str.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
