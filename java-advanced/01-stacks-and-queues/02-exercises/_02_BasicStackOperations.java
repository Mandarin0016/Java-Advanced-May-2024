import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _02_BasicStackOperations {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //n-5 s-2 x-13
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int s = input[1];
        int x = input[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int count = 1; count <= n; count++) {
            int number = scanner.nextInt();
            stack.push(number);
        }

        for (int count = 1; count <= s; count++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
