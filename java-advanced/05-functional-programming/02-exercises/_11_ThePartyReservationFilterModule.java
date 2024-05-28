import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _11_ThePartyReservationFilterModule {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));

        HashMap<String, Predicate> predicates = new HashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("Print")) {

            String[] input = command.substring(command.indexOf(";") + 1).split("([ ;]+)");
            int index = 2;
            if (input.length == 2) {
                index = 1;
            }
            String name = input[0] + input[index];

            if (command.contains("Add")) {
                Predicate<String> predicate = null;
                switch (input[0]) {
                    case "Starts":
                        predicate = s -> s.startsWith(input[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Ends":
                        predicate = s -> s.endsWith(input[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Length":
                        predicate = s -> s.length() == Integer.parseInt(input[2]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                    case "Contains":
                        predicate = s -> s.contains(input[1]);
                        predicates.putIfAbsent(name, predicate);
                        break;
                }
            } else {
                predicates.remove(name);
            }
            command = scanner.nextLine();
        }

        for (String guest : guests) {
            boolean isGoing = true;

            for (String entry : predicates.keySet()) {
                if (predicates.get(entry).test(guest)) {
                    isGoing = false;
                    break;
                }
            }
            if (isGoing) {
                System.out.print(guest + " ");
            }
        }
    }
}