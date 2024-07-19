package solid.calculator;

import solid.products.*;

import java.util.List;

public class CalorieCalculator implements Calculator {

    public int sum;

    public double sum(List<Product> products) {
        double sum = 0;
        for (Product product : products) {
            sum += product.getCalorie();
        }
        return sum;
    }

    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
