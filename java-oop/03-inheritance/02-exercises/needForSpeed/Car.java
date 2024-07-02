package needForSpeed;

public class Car extends Vehicle {

    public Car(double fuel, int horsePower) {
        // Тук реферирам към конструктора на бащиният клас
        super(fuel, horsePower);
        // Тук реферирам към метода setFuelConsumption в бащиният клас
        super.setFuelConsumption(3);
    }
}
