package wildfarm;

public abstract class Food {
    private final Integer quantity;

    protected Food(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
