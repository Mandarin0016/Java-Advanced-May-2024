package wildfarm;

public class Mouse extends Mammal {
    public Mouse(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eatFood(Food food) {
        if (!(food instanceof Vegetable)) {
            System.out.println("Mice are not eating that type of food!");
            return;
        }
        super.eatFood(food);
    }
}
