package _01_Person;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Вземам всички интерфейси на класа Citizen
        Class[] citizenInterfaces = Citizen.class.getInterfaces();

        // Проверям дали в тези интерфеси се намира интерфейса Person
        if (Arrays.asList(citizenInterfaces).contains(Person.class)) {

            // Вземам всички дефинирани методи в интерфейса Person
            Method[] methods = Person.class.getDeclaredMethods();

            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            int age = Integer.parseInt(scanner.nextLine());

            Person person = new Citizen(name, age);

            System.out.println(methods.length);
            System.out.println(person.getName());
            System.out.println(person.getAge());
        }
    }
}
