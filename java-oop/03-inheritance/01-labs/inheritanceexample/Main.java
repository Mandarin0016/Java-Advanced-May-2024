package inheritanceexample;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.bark();

//            CTE reference of type Animal cannot invoke methods in
//            class Dog
//        Animal animal = new Dog();
//        animal.eat();
//        animal.bark();

        feed(new Dog());
        feed(new Cat());
        feed(new Animal());
    }

    public static void feed(Animal animal) {
        animal.eat();
    }
}
