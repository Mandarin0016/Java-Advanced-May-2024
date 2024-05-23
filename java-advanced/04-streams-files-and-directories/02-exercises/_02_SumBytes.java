import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class _02_SumBytes {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));
        Scanner scanner = new Scanner(new FileReader("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));

        int sum = 0;
        //НАЧИН 1: BufferedReader
        String line = bufferedReader.readLine();
        while (line != null) {
            for (char symbol : line.toCharArray()) {
                sum += symbol;
            }
            line = bufferedReader.readLine();
        }

        //НАЧИН 2: Scanner
//        while (scanner.hasNextLine()) {
//            String line2 = scanner.nextLine();
//            for (char symbol : line2.toCharArray()) {
//                sum += symbol;
//            }
//        }

        System.out.println(sum);
    }
}
