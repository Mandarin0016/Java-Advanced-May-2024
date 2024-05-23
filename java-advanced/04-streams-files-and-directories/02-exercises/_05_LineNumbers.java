import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_LineNumbers {

    public static void main(String[] args) throws IOException {

        String path = "java-advanced/04-streams-files-and-directories/02-exercises/inputLineNumbers.txt";

        List<String> lines = Files.readAllLines(Path.of(path));

        PrintWriter writer = new PrintWriter("java-advanced/04-streams-files-and-directories/02-exercises/output.txt");

        int counter = 1;
        for (String line : lines) {
            String output = String.format("%d. %s", counter, line);
            counter++;
            writer.println(output);
        }

        writer.close();
    }
}
