package _01_Vehicles;

public class Truck extends Vehicle {

    public Truck(double fuelQuantity, double fuelCostPerKm) {
        super(fuelQuantity, fuelCostPerKm + 1.6);
    }

    @Override
    public void refuel(double fuelToRefill) {
        double totalFuelToRefill = fuelToRefill * 0.95;
        this.setFuelQuantity(this.getFuelQuantity() + totalFuelToRefill);
    }
}
