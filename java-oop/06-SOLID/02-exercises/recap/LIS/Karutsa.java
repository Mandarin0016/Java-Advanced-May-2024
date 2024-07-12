package recap.LIS;

public class Karutsa extends Car {

    @Override
    public void start() {
        System.out.println("Starting karutsa.");
    }

    @Override
    public void drive() {
        throw new UnsupportedOperationException("Karutsa can't be driven!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping karutsa.");
    }
}
