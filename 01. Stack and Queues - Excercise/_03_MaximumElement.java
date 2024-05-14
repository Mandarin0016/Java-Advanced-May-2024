import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class _03_MaximumElement {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int count = 1; count <= n; count++) {

            //[1, X]
            //[2]
            //[3]
            int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // НАЧИН 1:
//            switch (input[0]) {
//                case 1 -> stack.push(input[1]);
//                case 2 -> stack.pop();
//                case 3 -> System.out.println(Collections.max(stack));
//            }

            // НАЧИН 2:
            switch (input[0]) {
                case 1:
                    stack.push(input[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
