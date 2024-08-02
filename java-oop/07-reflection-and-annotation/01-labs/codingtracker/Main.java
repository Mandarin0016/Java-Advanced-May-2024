package codingtracker;

import java.lang.reflect.Method;

public class Main {

    @Author(name = "George")
    public static void main(String[] args) {
        printMethodsByAuthor(Main.class);
    }

    @Author(name = "Pesho")
    public static void printMethodsByAuthor(Class<?> clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            Author annotation = method.getAnnotation(Author.class);
            System.out.println(annotation.name() + ": " + method.getName() + "()");
        }

    }
}
