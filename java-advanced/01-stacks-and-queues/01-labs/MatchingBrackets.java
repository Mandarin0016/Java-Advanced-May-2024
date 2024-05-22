import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char currSymbol = expression.charAt(i);
            if (currSymbol == '(') {
                stack.push(i);
            } else if (currSymbol == ')') {
                int begin = stack.pop();
                int end = i + 1;
                String output = expression.substring(begin, end);
                System.out.println(output);
            }
        }
    }
}
