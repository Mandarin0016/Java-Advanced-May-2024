package recap;

public class Main_05 {

    public static void main(String[] args) {

//        Cat lion = new Lion();
//        Cat tiger = new Tiger();
//        Cat jaguar = new Jaguar();
//
//        lion.run();
//        tiger.run();
//        jaguar.run();
//
//        Dolittle dolittle = new Dolittle();
//
//        Lion simba = new Lion();
//        dolittle.healCat(simba);
//
////        dolittle.healCat(lion);
//        dolittle.healCat(tiger);
//        dolittle.healCat(jaguar);

        // 1. Method overriding (Runtime polymorphism)
        // 2. Method overloading (Compile-Time polymorphism)

        multiply(5, 1);
        multiply(10.5, 5.3);
    }

    public static void multiply(int a, int b) {
        System.out.println(a * b);
    }

    public static void multiply(double a, double b) {
        System.out.println(a * b);
    }

    public static void multiply(double a, double b, double c) {
        System.out.println(a * b * c);
    }
}
