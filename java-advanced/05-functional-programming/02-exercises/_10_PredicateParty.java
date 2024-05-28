import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _10_PredicateParty {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        String command = scanner.nextLine();
        while (!command.equals("Party!")) {

            Predicate<String> predicate = null;

            String criteria = command.split("\\s+")[2];
            if (command.contains("Length")) {
                predicate = x -> x.length() == Integer.parseInt(criteria);
            } else if (command.contains("StartsWith")) {
                predicate = x -> x.startsWith(criteria);
            } else {
                predicate = x -> x.endsWith(criteria);
            }

            if (command.contains("Remove")) {
                ArrayList<String> toRemove = new ArrayList<>();
                for (String guest : guests) {
                    if (predicate.test(guest)) {
                        toRemove.add(guest);
                    }
                }
                guests.removeAll(toRemove);
            } else {
                ArrayList<String> toAdd = new ArrayList<>();
                for (String guest : guests) {
                    if (predicate.test(guest)) {
                        toAdd.add(guest);
                    }
                }
                guests.addAll(toAdd);
            }

            command = scanner.nextLine();
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(guests.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}