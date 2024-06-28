package protecteddemo;

public class Animal {
    private String name;
    private int weight;

    public Animal(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Animal() {
    }

    protected String getName() {
        System.out.println("getName() from Animal");
        return name;
    }

    public void eat() {
        System.out.println("I am eating jam jam jam");
    }
}
