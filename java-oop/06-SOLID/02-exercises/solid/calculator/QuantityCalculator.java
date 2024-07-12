package solid.calculator;

import solid.products.Product;
import solid.products.drink.Drink;
import solid.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator {

    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            if (product instanceof Drink) {
                sum += ((Drink) product).getLiters();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }
        }
        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
