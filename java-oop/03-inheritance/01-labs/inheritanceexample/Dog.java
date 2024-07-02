package inheritanceexample;

public class Dog extends Animal {
    public void bark() {
        System.out.println("barking...");
    }

    @Override
    public void eat() {
        System.out.println("I am eating meat...");
    }
}
