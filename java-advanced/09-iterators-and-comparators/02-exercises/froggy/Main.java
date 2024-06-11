package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .toList();

        Lake lake = new Lake(numbers);
        List<String> iteratedNumbers = new ArrayList<>();

        for (Integer number : lake) {
            iteratedNumbers.add(number.toString());
        }
        System.out.println(String.join(", ", iteratedNumbers));
    }
}
