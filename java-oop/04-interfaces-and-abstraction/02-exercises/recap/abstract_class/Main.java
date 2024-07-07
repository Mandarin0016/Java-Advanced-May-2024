package recap.abstract_class;

public class Main {

    public static void main(String[] args) {

        Pizza hawaiiPizza = new HawaiiPizza("Summer Hawaii", 19.99);
        Pizza pepperoniPizza = new PepperoniPizza("Spicy Pepperoni", 10.99);

        System.out.println("Ingredients: " + hawaiiPizza.getIngredients());
        System.out.println("Ingredients: " + pepperoniPizza.getIngredients());
    }
}
