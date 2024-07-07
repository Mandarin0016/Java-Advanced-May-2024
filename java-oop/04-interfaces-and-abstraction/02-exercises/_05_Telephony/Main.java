package _05_Telephony;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //0882134215 0882134333 08992134215 0558123 3333 1
        //http://softuni.bg http://youtube.com http://www.g00gle.com
        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");

        Smartphone smartphone = new Smartphone(List.of(phoneNumbers), List.of(urls));
        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}