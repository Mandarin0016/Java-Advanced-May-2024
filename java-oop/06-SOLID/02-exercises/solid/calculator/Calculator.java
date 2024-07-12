package solid.calculator;

import solid.products.Product;

import java.util.List;

public interface Calculator {

    double sum(List<Product> products);

    double average(List<Product> products);

}
