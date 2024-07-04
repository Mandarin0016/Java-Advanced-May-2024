package demo;

// Ако един клас наследява АБСТРАКТЕН КЛАС, то този клас е задължен да даде имплементация на абстрактните методи
// в АБСТРАКТНИЯТ КЛАС
public class Lamborghini extends Car {

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public void drive() {

    }
}
