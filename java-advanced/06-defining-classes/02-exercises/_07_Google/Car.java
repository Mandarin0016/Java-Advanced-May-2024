package _07_Google;

public class Car {

    private String model;
    private String speed;

    public Car(String model, String speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.model, this.speed);
    }
}
