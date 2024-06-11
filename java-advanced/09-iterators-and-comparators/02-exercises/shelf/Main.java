package shelf;

public class Main {

    public static void main(String[] args) {

        // 1. Varargs
        printName("Vik", "Ivan", "Tosho", "Gosho");
        printName("Vik");

        

    }

    // 1. Varargs винаги са последен аргумент
    // 2. Varargs винаги са един арумент в параматерите на метода
    private static void printName(String city, String... names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
