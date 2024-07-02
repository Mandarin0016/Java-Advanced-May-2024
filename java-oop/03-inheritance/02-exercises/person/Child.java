package person;

public class Child extends Person {

    // Правило: Всеки sub-class (дъщерен клас) трябва да удовлетворява
    // конструктора на бащиният си клас!
    public Child(String name, int age) {
        // Когато създавам обект от клас, който наследява друг клас,
        // Java винаги ще се опита да извика конструктора на бащиният клас
        super(name, age);
    }
}
