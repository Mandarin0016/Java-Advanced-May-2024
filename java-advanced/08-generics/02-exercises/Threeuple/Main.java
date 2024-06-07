package Threeuple;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] firstRow = scanner.nextLine().split(" ");
        Threeuple<String, String, String> threeuple1 = new Threeuple<>(firstRow[0] + " " + firstRow[1], firstRow[2], firstRow[3]);

        String[] secondRow = scanner.nextLine().split(" ");
        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(secondRow[0], Integer.parseInt(secondRow[1]), secondRow[2].equals("drunk"));

        String[] thirdRow = scanner.nextLine().split(" ");
        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(thirdRow[0], Double.parseDouble(thirdRow[1]), thirdRow[2]);

        System.out.println(threeuple1);
        System.out.println(threeuple2);
        System.out.println(threeuple3);
    }
}
