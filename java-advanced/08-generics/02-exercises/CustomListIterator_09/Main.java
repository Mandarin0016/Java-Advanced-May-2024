package CustomListIterator_09;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {

            String command = input.split("\\s+")[0];

            switch (command) {
                case "Add":
                    String elementToAdd = input.split("\\s+")[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int index = Integer.parseInt(input.split("\\s+")[1]);
                    list.remove(index);
                    break;
                case "Contains":
                    String elementToCheck = input.split("\\s+")[1];
                    System.out.println(list.contains(elementToCheck));
                    break;
                case "Swap":
                    int index1 = Integer.parseInt(input.split("\\s+")[1]);
                    int index2 = Integer.parseInt(input.split("\\s+")[2]);
                    list.swap(index1, index2);
                    break;
                case "Greater":
                    String elementToCompareWith = input.split("\\s+")[1];
                    System.out.println(list.countGreaterValues(elementToCompareWith));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.println(list);
                    break;
                case "Sort":
                    list.sort();
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
