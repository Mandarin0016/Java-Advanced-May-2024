package wildfarm;

public class Zebra extends Mammal {
    public Zebra(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eatFood(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Zebras are not eating that type of food!");
            return;
        }
        super.eatFood(food);
    }
}
