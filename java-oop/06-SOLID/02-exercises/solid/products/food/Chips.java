package solid.products.food;

import solid.products.Product;

public class Chips implements Food {

    public static final double CALORIES_PER_100_GRAMS = 529.0;

    private double grams;

    public Chips(double grams) {
        this.grams = grams;
    }

    public double getGrams() {
        return grams;
    }

    @Override
    public double getCalorie() {

        return  (Chips.CALORIES_PER_100_GRAMS / 100) * getGrams();
    }

    @Override
    public double getKilograms() {
        return grams / 1000;
    }
}
