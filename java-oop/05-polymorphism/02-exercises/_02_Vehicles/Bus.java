package _02_Vehicles;

public class Bus extends Vehicle {

    private double emptyBusFuelCostPerKm;
    private double nonEmptyBusFuelCostPerKm;

    public Bus(double fuelQuantity, double fuelCostPerKm, double tankCapacity) {
        super(fuelQuantity, fuelCostPerKm, tankCapacity);
        this.emptyBusFuelCostPerKm = fuelCostPerKm;
        this.nonEmptyBusFuelCostPerKm = fuelCostPerKm + 1.4;
    }

    // Карам автобус с хора! НЕ Е ПРАЗЕН!
    public String drive(double distance) {

        this.setFuelCostPerKm(nonEmptyBusFuelCostPerKm);
        // изпълни логиката/метода написан бащиният клас!
        return super.drive(distance);
    }

    // Карам автобус без хора! Е ПРАЗЕН!
    public String driveEmpty(double distance) {

        this.setFuelCostPerKm(emptyBusFuelCostPerKm);
        return super.drive(distance);
    }
}
