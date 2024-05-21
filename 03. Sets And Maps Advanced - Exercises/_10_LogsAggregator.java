import java.util.*;

public class _10_LogsAggregator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> usersWithTime = new TreeMap<>();
        Map<String, Set<String>> addresses = new TreeMap<>();

        while (n-- > 0) {

            String[] tokens = scanner.nextLine().split("\\s+");

            String ip = tokens[0];
            String name = tokens[1];
            int time = Integer.parseInt(tokens[2]);

            if (!usersWithTime.containsKey(name)) {
                usersWithTime.put(name, time);
                addresses.put(name, new TreeSet<>());
                addresses.get(name).add(ip);
            } else {
                usersWithTime.put(name, usersWithTime.get(name) + time);
                addresses.get(name).add(ip);
            }
        }

        usersWithTime.entrySet().forEach(entry -> System.out.println(String.format("%s: %d %s", entry.getKey(), entry.getValue(), addresses.get(entry.getKey()).toString())));
    }
}
