package demo;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal animal = createAnimal();
        animal.eat();

    }

    public static Animal createAnimal() {
        Random random = new Random();

        int value = random.nextInt(100);

        if (value < 33) {
            return new Person();
        } else if (value < 66) {
            return new Dog();
        }
        return new Cat();
    }
}
