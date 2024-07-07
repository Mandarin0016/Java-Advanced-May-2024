package recap.abstract_class;

public abstract class Pizza {

    private String name;
    private double price;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void bake() {
        System.out.printf("Baking the %s pizza at 200 degrees.", this.name);
    }

    public void deliver() {
        System.out.printf("Pizza %s is ready to be delivered. Cost %.2f", this.name, this.price);
    }

    public abstract String getIngredients();
}
