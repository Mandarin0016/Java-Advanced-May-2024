package demo;

// 1. Може да съдържа абстрактни методи!
// 2. Абстрактният клас НЕ МОЖЕ да бъде инстанциран - не мога да създавам обекти от него!
public abstract class Car implements Driveable {

    public void sell() {
        System.out.println("Sold for 10$");
    }

    // Абстрактен метод! = Метод без имплементация
    public abstract double getCost();
}
