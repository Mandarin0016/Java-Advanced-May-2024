package recap.abstract_class;

public class HawaiiPizza extends Pizza {

    public HawaiiPizza(String name, double price) {
        super(name, price);
    }

    public String getIngredients() {
        return "Pineapple, Ham, Tomato Sauce.";
    }
}
