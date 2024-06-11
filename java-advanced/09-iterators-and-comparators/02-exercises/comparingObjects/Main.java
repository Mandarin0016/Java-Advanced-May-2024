package comparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        //{name} {age} {town}
        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            String town = input.split(" ")[2];

            Person person = new Person(name, age, town);
            people.add(person);

            input = scanner.nextLine();
        }

        int index = Integer.parseInt(scanner.nextLine()) - 1;
        Person nthPerson = people.get(index);

        int countEqual = 0;
        for (Person person : people) {
            if (person.compareTo(nthPerson) == 0) {
                countEqual++;
            }
        }

        if (countEqual > 1) {
            System.out.printf("%d %d %d", countEqual, people.size() - countEqual, people.size());
        } else {
            System.out.println("No matches");
        }
    }
}
