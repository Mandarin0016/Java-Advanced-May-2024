import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String input = scanner.nextLine();
        String currentURL = "";

        while (!input.equals("Home")) {
            String output = "no previous URLs";
            if (input.equals("back")) {
                if (!stack.isEmpty()) {
                    currentURL = stack.pop();
                    output = currentURL;
                }
            } else {
                if (!currentURL.isEmpty()) {
                    stack.push(currentURL);
                }
                currentURL = input;
                output = currentURL;
            }
            input = scanner.nextLine();
            System.out.println(output);
        }
    }
}
