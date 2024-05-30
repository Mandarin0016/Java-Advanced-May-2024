import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {

    private static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person p = new Person(name, age);
            people.add(p);
        }

        String ageCriteria = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> personPredicate = getPersonPredicate(ageCriteria, age);
        Consumer<Person> printer = getPrinter(format);

        filterAndPrintPeople(personPredicate, printer, people);
    }

    private static void filterAndPrintPeople(Predicate<Person> predicate,
                                             Consumer<Person> consumer,
                                             List<Person> people) {
        people.stream()
                .filter(predicate)
                .forEach(consumer);
    }

    private static Consumer<Person> getPrinter(String format) {
        return switch (format) {
            case "name age" -> p -> System.out.println(p.name + " - " + p.age);
            case "name" -> p -> System.out.println(p.name);
            case "age" -> p -> System.out.println(p.age);
            default -> throw new IllegalArgumentException("Unsupported input format " + format);
        };
    }

    private static Predicate<Person> getPersonPredicate(String ageCriteria, int age) {
        return switch (ageCriteria) {
            case "younger" -> p -> p.age <= age;
            case "older" -> p -> p.age >= age;
            default -> throw new IllegalArgumentException("Unsupported input criteria " + ageCriteria);
        };
    }
}
