import sortbynameandage.Person;

public class Demo {
    public static void main(String[] args) {


        String immutableObj = "The quick brown fox jumps over the lazy dog";

        String newStr = immutableObj.replaceAll(" ", "<====>");

        System.out.println(immutableObj);
        System.out.println(newStr);

        Person person = new Person("Pesho", "Ivanov", 42, 1000);

        System.out.println(person.toString());

        person.setSalary(1200);

        System.out.println(person.toString());
    }
}
