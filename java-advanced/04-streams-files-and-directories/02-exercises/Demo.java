import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {

        // 1. BufferedReader:
        // Как прочита файл: Ефективно четене на редове, добър за четене на големи файлове поради буферната памет, която използва.
        // Обичайна употреба: Четене на големи текстови файлове ред по ред.
        BufferedReader bufferedReader = new BufferedReader(new FileReader("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));
        System.out.println(bufferedReader.readLine());

        // 2. Scanner:
        // Как прочита файл: Лесен за използване, но може да бъде по-бавен и не толкова ефективен при големи файлове.
        // Обичайна употреба: Четене от конзолата.
        Scanner scanner = new Scanner(new File("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));
        System.out.println(scanner.nextLine());

        // 3. Четене с FileReader:
        // Как прочита файл: Прочита файл символ по символ. Не е ефективен за големи файлове.
        // Обичайна употреба: Четене на много малки текстови файлове
        FileReader fileReader = new FileReader("java-advanced/04-streams-files-and-directories/02-exercises/input.txt");
        System.out.println((char) fileReader.read());

        // 4. Четене с Files.readAllLines:
        // Как прочита файл: Чете всички редове наведнъж, лесен за използване, използва BufferedReader
        List<String> allLines = Files.readAllLines(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));
        System.out.println(allLines.get(0));

        // 5. Четене с Files.readString:
        // Как прочита файл: Чете цялото съдържание на файла наведнъж, връща String. Лесен за използване!
        String fullContent = Files.readString(Path.of("java-advanced/04-streams-files-and-directories/02-exercises/input.txt"));
        System.out.println(fullContent);


        // 1. Писане с PrintWriter:
        // Лесен за използване, има добре познати методи като print(), println(), printf()
        // Изисква изрично извикване на flush или close за да се запишат данните, които се опитваме да напишем на файла.
        PrintWriter printWriter = new PrintWriter("output.txt");
        printWriter.println("Hello, World!");
        printWriter.println("Another line.");
        // Затватяме потока от информация към този файл и всички наши промени ще се отразят във файла
        printWriter.close();

        // 2. Писане с BufferedWriter:
        // Ефективен за писане на големи количества данни благодарение на буфериране.
        // Изисква изрично извикване на flush или close за да се запишат данните, които се опитваме да напишем на файла.
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
        bufferedWriter.write("Hello, World!");
        bufferedWriter.newLine(); // Добавя нов ред
        bufferedWriter.write("Another line.");
        bufferedWriter.close();

        // 3. Писане с FileWriter:
        // Прост и директен начин за писане по файлове, като данните ще се записват символ по символ, както става четенето при FileReader класа
        // Не ползва буферна памет, по-малко ефективен за големи файлове
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write("Hello, World!\n");
        fileWriter.write("Another line.\n");
        fileWriter.close();
    }
}
