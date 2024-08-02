package dolphinarium.entities.pools;

import dolphinarium.entities.dolphins.Dolphin;
import dolphinarium.entities.foods.Food;

import java.util.Collection;
//TODO Implement all methods

public interface Pool {
    String getName();

    int getCapacity();

    Collection<Dolphin> getDolphins();

    Collection<Food> getFoods();


    void addDolphin(Dolphin dolphin);

    void removeDolphin(Dolphin dolphin);

    void addFood(Food food);

}
