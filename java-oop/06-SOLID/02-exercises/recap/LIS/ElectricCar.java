package recap.LIS;

public class ElectricCar extends Car{

    @Override
    public void start() {
        System.out.println("Starting electric car.");
    }

    @Override
    public void drive() {
        System.out.println("Driving electric car.");
    }

    @Override
    public void stop() {
        System.out.println("Stopping electric car.");
    }
}
