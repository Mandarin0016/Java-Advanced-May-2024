package froggy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //1, 2, 3, 4, 5, 6, 7, 8
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Lake lake = new Lake(numbers);

        List<String> output = new ArrayList<>();
        for (Integer number : lake) {
            output.add(number.toString());
        }

        System.out.println(String.join(", ", output));
    }
}
