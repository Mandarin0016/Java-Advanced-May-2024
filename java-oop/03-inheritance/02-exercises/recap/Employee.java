package recap;

public class Employee {

    private String name;
    private double salary;

    public void present() {
        System.out.printf("My name is %s and my salary is %.2f", name, salary);
    }
}
