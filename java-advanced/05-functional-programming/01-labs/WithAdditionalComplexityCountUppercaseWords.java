import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class WithAdditionalComplexityCountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Predicate<String> startsWithUppercase =
                s -> Character.isUpperCase(s.charAt(0));

        StringBuilder out = new StringBuilder();

        AtomicInteger count = new AtomicInteger(0);

        Arrays.stream(text.split("\\s+"))
                .filter(startsWithUppercase)
                .forEach(e -> {
                    count.getAndIncrement();
                    out.append(e).append(System.lineSeparator());
                });

        System.out.println(count);
        System.out.println(out);
    }
}
