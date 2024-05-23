import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines {

    public static void main(String[] args) throws IOException {

        String path = "java-advanced/04-streams-files-and-directories/02-exercises/input.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        for (String line : lines) {
            int sum = 0;
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            System.out.println(sum);
        }
    }
}
