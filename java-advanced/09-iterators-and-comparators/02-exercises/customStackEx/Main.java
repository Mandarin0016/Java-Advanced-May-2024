package customStackEx;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            // Pop
            // Push 2, 3, 5, 8
            if (command.equals("Pop")) {
                stack.pop();
            } else {
                int[] numbers = Arrays.stream(command.replace("Push ", "") // "2, 3, 5, 8"
                                .split(", ")) // [2, 3, 5, 8]
                        .mapToInt(Integer::parseInt) // [2, 3, 5, 8]
                        .toArray();
                for (int number : numbers) {
                    stack.push(number);
                }
            }
            command = scanner.nextLine();
        }

        for (Integer number : stack) {
            System.out.println(number);
        }
        for (Integer number : stack) {
            System.out.println(number);
        }
    }
}
