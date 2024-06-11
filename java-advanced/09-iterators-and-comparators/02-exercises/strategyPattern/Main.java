package strategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> peopleSortedByName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> peopleSortedByAge = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row < n; row++) {

            //Peter 20
            String line = scanner.nextLine();
            String name = line.split(" ")[0];
            int age = Integer.parseInt(line.split(" ")[1]);

            Person person = new Person(name, age);
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }

        peopleSortedByName.forEach(System.out::println);
        peopleSortedByAge.forEach(System.out::println);
    }
}
