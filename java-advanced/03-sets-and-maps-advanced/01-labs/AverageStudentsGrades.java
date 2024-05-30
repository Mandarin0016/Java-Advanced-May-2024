import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> studentsWithGrades = new TreeMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            studentsWithGrades.putIfAbsent(name, new ArrayList<>());
            List<Double> grades = studentsWithGrades.get(name);
            grades.add(grade);
        }

        for (var entry : studentsWithGrades.entrySet()) {
            String name = entry.getKey();

            StringBuilder output = new StringBuilder();
            double sum = 0;
            for (Double grade : entry.getValue()) {
                output.append(String.format("%.2f ", grade));
                sum += grade;
            }

            System.out.printf("%s -> %s(avg: %.2f)%n", name, output, sum / entry.getValue().size());
        }
    }
}
