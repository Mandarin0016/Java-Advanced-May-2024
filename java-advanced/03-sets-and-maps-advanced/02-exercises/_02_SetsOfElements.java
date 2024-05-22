import java.util.*;

public class _02_SetsOfElements {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        int n = input[0];
        int m = input[1];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        // Начин 1:
        // firstSet.retainAll(secondSet);

        // Начин 2:
        for (int number : firstSet) {
            if (secondSet.contains(number)) {
                System.out.print(number + " ");
            }
        }
    }
}
