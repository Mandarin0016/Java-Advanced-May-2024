package getterandsetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] declaredMethods = clazz.getDeclaredMethods();

        Arrays.stream(declaredMethods)
                .filter(m -> !m.getName().contains("toString"))
                .sorted(Comparator.comparing(Method::getName))
                .map(Main::toString)
                .forEach(System.out::println);
    }

    private static String toString(Method method) {
        if (method.getName().contains("get")) {
            return method.getName() + " will return class " + method.getReturnType().getName();
        }

        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> parameter = parameterTypes[0];
        return method.getName() + " and will set field of class " + parameter.getName();
    }
}
