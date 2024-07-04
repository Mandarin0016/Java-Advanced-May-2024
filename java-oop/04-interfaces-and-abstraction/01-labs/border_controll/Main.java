package border_controll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Identifiable> individuals = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("End")) {

            String[] individualData = command.split("\\s+");

            if (individualData.length == 2) {
                //MK-13 558833251
                String model = individualData[0];
                String id = individualData[1];
                Robot robot = new Robot(model, id);
                individuals.add(robot);
            } else {
                //Peter 22 9010101122
                String name = individualData[0];
                int age = Integer.parseInt(individualData[1]);
                String id = individualData[2];
                Citizen citizen = new Citizen(name, age, id);
                individuals.add(citizen);
            }

            command = scanner.nextLine();
        }

        // 122
        String idSuffix = scanner.nextLine();

        individuals.stream()
                .filter(individual -> individual.getId().endsWith(idSuffix)) // условие: ид да завършва на 'idSuffix'
                .forEach(individual -> System.out.println(individual.getId()));
    }
}
