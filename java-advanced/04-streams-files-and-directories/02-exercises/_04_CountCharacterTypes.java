import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class _04_CountCharacterTypes {

    public static void main(String[] args) throws IOException {

        String content = Files.readString(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));

        content = content.replaceAll("\\s+", "");

        int countVowels = 0;
        int countPunctuations = 0;
        int countOthers = 0;

        for (char symbol : content.toCharArray()) {

            if (isVowel(symbol)) {
                countVowels++;
            } else if (isPunctuation(symbol)) {
                countPunctuations++;
            } else {
                countOthers++;
            }
        }

        PrintWriter writer = new PrintWriter("java-advanced/04-streams-files-and-directories/02-exercises/output.txt");
        writer.println("Vowels: " + countVowels);
        writer.println("Other symbols: " + countOthers);
        writer.println("Punctuation: " + countPunctuations);
        writer.close();
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == '?' || symbol == '.' || symbol == ',';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}
