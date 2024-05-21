import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> symbolCount = new TreeMap<>();

        String line = scanner.nextLine();

        for (char symbol : line.toCharArray()) {
            // 1. Имам ли запис, който пазии бройката появи за тази буква
            // Ако имам:
            if (symbolCount.containsKey(symbol)) {
                //  -> увеличавам броят с 1 (+1)
                int count = symbolCount.get(symbol) + 1;
                symbolCount.put(symbol, count);
            }
            // Ако нямам:
            else {
                //  -> нов запис с брой 1
                symbolCount.put(symbol, 1);
            }
        }

        // entrySet() -> съвкупност от записи
        // entry -> един запис
        symbolCount.entrySet().forEach(entry -> System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue()));
    }
}
