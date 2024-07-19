import java.lang.reflect.*;

public class Main_7 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {

        // Достъп до класа
        Class personClass = Human.class;

        // Достъп до полетата
        // Declared = всичко
        Field[] allFields = personClass.getDeclaredFields();
        Field[] publicFields = personClass.getFields();

        // Достъп до конструктор
        Constructor<Human> constructor = personClass.getConstructor(String.class, int.class);

        // Създаваме обект чрез конструктора
        Human human = constructor.newInstance("Ivan", 20);

        // Достъп до методите
        Method[] allMethods = personClass.getDeclaredMethods();
        Method[] publicMethods = personClass.getMethods();

        Method getNameMethod = personClass.getDeclaredMethod("getName");
        getNameMethod.setAccessible(true);
        System.out.println(getNameMethod.invoke(human));

        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true);
        System.out.println(ageField.get(human));

        Field nameField = personClass.getDeclaredField("name");

        // getModifiers() -> маска
        int mask = nameField.getModifiers();
        System.out.println(Modifier.toString(mask));
    }
}
