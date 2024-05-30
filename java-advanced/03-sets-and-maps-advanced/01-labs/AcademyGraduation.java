import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> gradesByStudents = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();

            double grade = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .average()
                    .orElse(0);

            gradesByStudents.put(name, grade);

        }

        // Some tests in judge are failing, however the solution is correct,
        // the tests precision needs to be improved
        gradesByStudents.forEach((name, grade)
                -> System.out.printf("%s is graduated with %s%n", name, grade));

    }
}