package dolphinarium.entities.dolphins;

//TODO Implement all methods


import dolphinarium.entities.foods.Food;

public interface Dolphin {
    String getName();
    int getEnergy();

    void jump();

    void eat(Food food);
}
