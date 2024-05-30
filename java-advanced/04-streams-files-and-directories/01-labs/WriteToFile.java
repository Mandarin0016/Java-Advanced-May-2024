import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        // Keep this file in the same directory as the project
        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output.txt");

        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            next = next.replaceAll("[,.!?]", "");
            for (int i = 0; i < next.length(); i++) {
                outputStream.write(next.charAt(i));
            }
            String lineSeparator = System.lineSeparator();
            for (int i = 0; i < lineSeparator.length(); i++) {
                outputStream.write(lineSeparator.charAt(i));
            }
        }

    }
}
