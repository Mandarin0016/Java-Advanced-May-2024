package _07_Google;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String flag = tokens[1];

            Person person = getPersonByName(people, personName);

            switch (flag) {
                case "company":
                    //"{Name} company {companyName} {department} {salary}"
                    String companyName = tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName, department, salary);
                    person.setCompany(company);
                    break;
                case "pokemon":
                    //"{Name} pokemon {pokemonName} {pokemonType}"
                    String pokemonName = tokens[2];
                    String pokemonType = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    person.addPokemon(pokemon);
                    break;
                case "parents":
                    //"{Name} parents {parentName} {parentBirthday}"
                    String parentName = tokens[2];
                    String parentBirthday = tokens[3];
                    Relative parent = new Relative(parentName, parentBirthday);
                    person.addParent(parent);
                    break;
                case "children":
                    //"{Name} children {childName} {childBirthday}"
                    String childName = tokens[2];
                    String childBirthday = tokens[3];
                    Relative child = new Relative(childName, childBirthday);
                    person.addChild(child);
                    break;
                case "car":
                    //"{Name} car {carModel} {carSpeed}"
                    String carModel = tokens[2];
                    String carSpeed = tokens[3];
                    Car car = new Car(carModel, carSpeed);
                    person.setCar(car);
                    break;
            }

            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        Person person = getPersonByName(people, name);
        System.out.println(person);
    }

    private static Person getPersonByName(List<Person> people, String personName) {

        for (Person person : people) {
            if (person.getName().equals(personName)) {
                return person;
            }
        }
        Person person = new Person(personName);
        people.add(person);
        return person;
    }
}
