package _04_FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // КУПЯ ХРАНА
        // ВЗЕМА КОЛИЧЕСТВО ХРАНА
        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < n; row++) {

            //Tony 44 7308185527 18/08/1973
            //Joro 31 Terrorists
            String[] commandParts = scanner.nextLine().split("\\s+");

            if (commandParts.length == 4) {
                String name = commandParts[0];
                int age = Integer.parseInt(commandParts[1]);
                String id = commandParts[2];
                String date = commandParts[3];
                Citizen citizen = new Citizen(name, age, id, date);
                citizens.add(citizen);
            } else {
                String name = commandParts[0];
                int age = Integer.parseInt(commandParts[1]);
                String group = commandParts[2];
                Rebel rebel = new Rebel(name, age, group);
                rebels.add(rebel);
            }
        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {

            for (Citizen citizen : citizens) {
                if (citizen.getName().equals(name)) {
                    citizen.buyFood();
                }
            }

            for (Rebel rebel : rebels) {
                if (rebel.getName().equals(name)) {
                    rebel.buyFood();
                }
            }

            name = scanner.nextLine();
        }

        int totalFood = 0;
        for (Citizen citizen : citizens) {
            totalFood += citizen.getFood();
        }
        for (Rebel rebel : rebels) {
            totalFood += rebel.getFood();
        }
        System.out.println(totalFood);
    }
}
