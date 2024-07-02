package inheritanceexample;

public class Cat extends Animal {

    public void meow() {
        System.out.println("meowing...");
    }

    @Override
    public void eat() {
        System.out.println("I am eating a mouse...");
    }

}
