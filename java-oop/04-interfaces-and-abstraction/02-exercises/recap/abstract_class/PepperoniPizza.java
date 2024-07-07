package recap.abstract_class;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza(String name, double price) {
        super(name, price);
    }

    public String getIngredients() {
        return "Pepperoni, Tomato Sauce, Mozzarella";
    }
}
