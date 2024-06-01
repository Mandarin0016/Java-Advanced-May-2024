import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.groupingBy(e -> e, LinkedHashMap::new, Collectors.counting()))
                .forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));
    }
}
