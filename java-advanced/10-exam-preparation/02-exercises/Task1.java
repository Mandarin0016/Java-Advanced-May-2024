import java.util.*;
import java.util.stream.Collectors;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //9 5 8 13 (стек)
        //13 8 5 6 (опашка)
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        // Стек -> добавяме - .push()  | премахваме/вземаме последният .pop()
        // Опашка -> добавяме - .offer()  | премахваме/вземаме първият .poll()

        // Пълня един ред от конзолата с цели числа в СТЕК
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stack::push);
        // Пълня един ред от конзолата с цели числа в ОПАШКА
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queue::offer);

        int initialWormCount = stack.size();
        int matches = 0;

        while (!stack.isEmpty() && !queue.isEmpty()) {

            //9 5 8 (стек)
            //13 8 5 6 (опашка)

            int worm = stack.pop();
            int hole = queue.poll();

            if (worm == hole) {
                matches++;
            } else {
                worm -= 3;
                // Ако моят червей не е умрял
                if (worm > 0) {
                    stack.push(worm);
                }
            }
        }

        if (matches > 0) {
            System.out.println("Matches: " + matches);
        } else {
            System.out.println("There are no matches.");
        }

        if (stack.isEmpty() && initialWormCount == matches) {
            System.out.println("Every worm found a suitable hole!");
        } else if (stack.isEmpty() && initialWormCount > matches) {
            System.out.println("Worms left: none");
        } else if (!stack.isEmpty()) {
            //17 20 25 10
            List<Integer> reversedStack = new ArrayList<>(stack);
            Collections.reverse(reversedStack);
            // Стек с цели числа!
            // .map(String::valueOf) -> взема едно число и го преобразува на текст
            String output = reversedStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Worms left: " + output);
        }

        if (queue.isEmpty()) {
            System.out.println("Holes left: none");
        } else {
            String output = queue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.println("Holes left: " + output);
        }
    }
}
