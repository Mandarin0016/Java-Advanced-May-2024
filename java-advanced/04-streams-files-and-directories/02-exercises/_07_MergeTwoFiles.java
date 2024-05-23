import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _07_MergeTwoFiles {

    public static void main(String[] args) throws IOException {

        String firstFileContent = Files.readString(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/inputOne.txt"));
        String secondFileContent = Files.readString(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/inputTwo.txt"));

        PrintWriter writer = new PrintWriter("java-advanced/04-streams-files-and-directories/02-exercises/output.txt");
        writer.println(firstFileContent);
        writer.println(secondFileContent);
        writer.close();
    }
}
