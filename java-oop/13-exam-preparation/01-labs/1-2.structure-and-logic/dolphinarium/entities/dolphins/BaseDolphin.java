package dolphinarium.entities.dolphins;

import dolphinarium.entities.foods.Food;

import static dolphinarium.common.ExceptionMessages.DOLPHIN_NAME_NULL_OR_EMPTY;

public abstract class BaseDolphin implements Dolphin {
    private String name;
    private int energy;

    protected BaseDolphin(String name, int energy) {
        setName(name);
        this.energy = energy;
    }

    private void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new NullPointerException(DOLPHIN_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void decreaseEnergy(int decrement) {
        energy -= decrement;
        energy = Math.max(energy, 0);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void eat(Food food) {
        energy += food.getCalories();
    }
}
