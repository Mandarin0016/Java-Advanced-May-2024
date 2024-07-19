public class Debugging {

    public static void main(String[] args) {


        int a = 10;
        int b = 5;

        Human human = new Human("Vik", 23);
        Human human2 = new Human("Vik", 23);
        Human human3 = new Human("Vik", 23);


        if (human.getAge() < 0) {
            throw new IllegalArgumentException();
        }


//        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");

        for (int i = 1; i <= 20; i++) {
            System.out.println(i);
            human.setName("Ivan");
        }

        System.out.println(sum(10, 5) == 15);
        System.out.println(sum(10, 5) == 15);
        System.out.println(sum(10, 5) == 15);
        System.out.println(sum(10, 5) == 15);
        System.out.println(sum(10, 5) == 15);
        System.out.println(sum(10, 5) == 15);

    }

    public static double sum(double a, double b) {
        return getA() + getB();
    }

    private static double getB() {
        return 2;
    }

    private static double getA() {
        return 1;
    }
}
