import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> reservations = new TreeSet<>();

        String input = scanner.nextLine();

        while (!input.equals("PARTY")) {
            String reservation = input;
            reservations.add(reservation);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("END")) {
            String reservation = input;
            reservations.remove(reservation);
            input = scanner.nextLine();
        }

        System.out.println(reservations.size());

        for (String reservation : reservations) {
            System.out.println(reservation);
        }
    }
}
