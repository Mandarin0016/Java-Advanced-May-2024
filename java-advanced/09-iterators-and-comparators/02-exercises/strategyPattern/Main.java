package strategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> byAgeOrdered = new TreeSet<>(new PersonAgeComparator());
        TreeSet<Person> byNameOrdered = new TreeSet<>(new PersonNameComparator());

        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < n; row++) {

            // {name} {age}
            String input = scanner.nextLine();

            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            Person person = new Person(name, age);
            byAgeOrdered.add(person);
            byNameOrdered.add(person);
        }

        byNameOrdered.forEach(System.out::println);
        byAgeOrdered.forEach(System.out::println);
    }
}
