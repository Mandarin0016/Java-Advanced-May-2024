package recap.abstract_class;

public class MargheritaPizza extends Pizza{

    public MargheritaPizza(String name, double price) {
        super(name, price);
    }

    public String getIngredients() {
        return "Tomato Sauce, Mozzarella, Basil";
    }
}
