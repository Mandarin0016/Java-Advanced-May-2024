package modifiers;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Arrays.stream(clazz.getDeclaredMethods())
                .forEach(m -> System.out.println(Modifier.toString(m.getModifiers())));
    }
}
