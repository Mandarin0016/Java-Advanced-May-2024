import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String registration = input.substring(input.lastIndexOf(" ")).trim();
            if (input.contains("IN")) {
                parkingLot.add(registration);
            } else {
                parkingLot.remove(registration);
            }

            input = scanner.nextLine();
        }

        String output = parkingLot.isEmpty()
                ? "Parking Lot is Empty"
                : String.join(System.lineSeparator(), parkingLot);

        System.out.println(output);
    }
}
