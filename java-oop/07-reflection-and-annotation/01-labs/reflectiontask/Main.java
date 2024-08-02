package reflectiontask;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);
        System.out.println(clazz.getSuperclass());

        Class<?>[] interfaces = clazz.getInterfaces();

        for (Class<?> i : interfaces) {
            System.out.println(i);
        }

        try {
            Constructor<Reflection> ctor = clazz.getConstructor();
            Reflection reflection = ctor.newInstance();
            System.out.println(reflection);
        } catch (NoSuchMethodException | InstantiationException
                | InvocationTargetException | IllegalAccessException ignored) {
        }
    }
}
