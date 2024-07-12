package solid.products.food;

public class Cloud implements Food {

    @Override
    public double getKilograms() {
        return 1;
    }

    @Override
    public double getCalorie() {
        throw new UnsupportedOperationException("Clouds can't be eaten!");
    }
}
