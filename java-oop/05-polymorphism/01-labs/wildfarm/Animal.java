package wildfarm;

public abstract class Animal {
    private final String name;
    private final String type;
    private final Double weight;
    private Integer foodEaten;

    protected Animal(String name, String type, Double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }

    public abstract void makeSound();
    public void eatFood(Food food) {
        foodEaten += food.getQuantity();
    }
}
