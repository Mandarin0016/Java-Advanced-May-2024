package _09_CatLady;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> catMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] data = input.split("\\s+");
            String breed = data[0];

            Cat cat;

            switch (breed) {
                case "Siamese":
                    cat = new Siamese(data[1], Double.parseDouble(data[2]));
                    break;
                case "Cymric":
                    cat = new Cymric(data[1], Double.parseDouble(data[2]));
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(data[1], Double.parseDouble(data[2]));
                    break;
                default:
                    throw new RuntimeException("Unknown breed!");
            }
            catMap.put(data[1], cat);
            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        if (catMap.containsKey(name)) {
            System.out.println(catMap.get(name).toString());
        }
    }
}
