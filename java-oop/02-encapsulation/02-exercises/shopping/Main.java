package shopping;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();

        //Peter=11;George=4
        String peopleData = scanner.nextLine();
        //Bread=10;Milk=2
        String productData = scanner.nextLine();

        //Peter=11
        for (String personInfo : peopleData.split(";")) {
            String name = personInfo.split("=")[0];
            double money = Double.parseDouble(personInfo.split("=")[1]);
            Person person = new Person(name, money);
            people.add(person);
        }

        //Bread=10
        for (String productInfo : productData.split(";")) {
            String name = productInfo.split("=")[0];
            double cost = Double.parseDouble(productInfo.split("=")[1]);
            Product product = new Product(name, cost);
            products.add(product);
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            //George Milk
            String personName = command.split(" ")[0];
            String productName = command.split(" ")[1];

            // Проверявам дали в един списък има обект, който отговаря на дадено условие.
            // products.stream().anyMatch(product -> product.getName().equals(productName))

            // .filter(p -> p.getName().equals(personName)) -> остави хората, които са с това име
            // .findFirst() -> намери първият, който е с това име
            // .get() -> върни ми резултата
            Person person = people.stream().filter(p -> p.getName().equals(personName)).findFirst().get();
            Product product = products.stream().filter(p -> p.getName().equals(productName)).findFirst().get();

            person.buyProduct(product);

            command = scanner.nextLine();
        }

    }
}
