package _03_SpeedRacing;

public class Car {

    private String model;
    private double fuel;
    private double fuelCostPerKm;
    private int distanceTraveled;

    public Car(String model, double fuel, double fuelCostPerKm) {
        this.model = model;
        this.fuel = fuel;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return this.model;
    }

    public void drive(int kmToDrive) {

        double requiredFuel = kmToDrive * this.fuelCostPerKm;
        if (this.fuel >= requiredFuel) {
            this.fuel -= requiredFuel;
            this.distanceTraveled += kmToDrive;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    // Този метод показва по какъв начин ще изглежда обект отт този клас във формата на Текст
    public String toString() {
        //"{Model} {fuelAmount} {distanceTraveled}"
        return String.format("%s %.2f %d", this.model, this.fuel, this.distanceTraveled);
    }
}
