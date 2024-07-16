package harvestingFields;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Class clazz = RichSoilLand.class;

        String command = scanner.nextLine();
        while (!command.equals("HARVEST")) {

            switch (command) {
                case "private":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(field -> Modifier.isPrivate(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    break;
                case "protected":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(field -> Modifier.isProtected(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    break;
                case "public":
                    Arrays.stream(clazz.getDeclaredFields())
                            .filter(field -> Modifier.isPublic(field.getModifiers()))
                            .forEach(field -> System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    break;
                case "all":
                    Arrays.stream(clazz.getDeclaredFields())
                            .forEach(field -> System.out.printf("%s %s %s\n", Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
