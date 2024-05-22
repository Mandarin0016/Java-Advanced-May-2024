import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> queue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(PriorityQueue::new));

        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + queue.peek());
            } else {
                System.out.println("Removed " + queue.poll());
            }
            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }

    static boolean isPrime(int cycle) {
        if (cycle <= 1) {
            return false;
        } else if (cycle == 2) {
            return true;
        } else if (cycle % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(cycle); i += 2) {
            if (cycle % i == 0)
                return false;
        }
        return true;
    }
}
