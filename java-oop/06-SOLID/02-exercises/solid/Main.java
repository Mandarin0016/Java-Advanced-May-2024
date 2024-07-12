package solid;

import solid.calculator.CalorieCalculator;
import solid.calculator.QuantityCalculator;
import solid.printer.Printer;

public class Main {

    public static void main(String[] args) {

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        QuantityCalculator quantityCalculator = new QuantityCalculator();

        Printer printer1 = new Printer(quantityCalculator);
        Printer printer2 = new Printer(calorieCalculator);
    }
}
