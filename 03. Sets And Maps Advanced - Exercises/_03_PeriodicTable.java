import java.util.*;

public class _03_PeriodicTable {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            //"Mo O Ce"
            String compound = scanner.nextLine();
            // ["Mo", "O", "Ce"]
            String[] elements = compound.split(" ");
            chemicalElements.addAll(List.of(elements));
        }

        chemicalElements.forEach(element -> System.out.print(element + " "));
    }
}
