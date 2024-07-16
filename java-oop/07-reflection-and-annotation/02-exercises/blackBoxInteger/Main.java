package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Scanner scanner = new Scanner(System.in);

        Class boxClass = BlackBoxInt.class;

        Constructor<BlackBoxInt> constructor = boxClass.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);

        Field innerValueField = boxClass.getDeclaredField("innerValue");
        innerValueField.setAccessible(true);

        BlackBoxInt box = constructor.newInstance(0);

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            //add_999999
            //subtract_19
            //END
            String methodName = command.split("_")[0];
            int value = Integer.parseInt(command.split("_")[1]);

            invokeMethodByName(methodName, value, box, boxClass);
            System.out.println(innerValueField.get(box));

            command = scanner.nextLine();
        }
    }

    private static void invokeMethodByName(String methodName, int value, BlackBoxInt box, Class boxClass) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Method method = boxClass.getDeclaredMethod(methodName, int.class);
        method.setAccessible(true);
        method.invoke(box, value);
    }
}
