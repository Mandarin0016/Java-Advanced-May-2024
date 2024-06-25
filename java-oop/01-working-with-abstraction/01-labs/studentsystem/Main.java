package studentsystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        String line = scanner.nextLine();

        while (!line.equals("Exit")) {
            String[] input = line.split("\\s+");
            String output = studentSystem.parseCommand(input);
            if (!output.isEmpty()) {
                System.out.println(output);
            }
            line = scanner.nextLine();
        }
    }
}
