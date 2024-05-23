import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class _03_AllCapitals {

    public static void main(String[] args) throws IOException {

        String content = Files.readString(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));

        content = content.toUpperCase();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("java-advanced/04-streams-files-and-directories/02-exercises/output.txt"));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }
}
