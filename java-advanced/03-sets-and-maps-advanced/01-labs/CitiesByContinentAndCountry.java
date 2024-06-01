import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>
                continentsData = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");

            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            continentsData.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, ArrayList<String>> countries = continentsData.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());
            ArrayList<String> cities = countries.get(country);
            cities.add(city);
        }

        for (var entry : continentsData.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (var innerEntry : entry.getValue().entrySet()) {
                String country = innerEntry.getKey();
                String cities = String.join(", ", innerEntry.getValue());
                System.out.printf("  %s -> %s%n", country, cities);
            }
        }
    }
}
