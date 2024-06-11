package customStackEx;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomStack stack = new CustomStack();

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            //Push 1, 2, 3, 4
            //Pop
            if (command.equals("Pop")) {
                stack.pop();
            } else {
                //[1, 2, 3, 4]
                int[] numbers = Arrays.stream(command.replace("Push ", "").split(", "))
                        .mapToInt(Integer::parseInt)
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
