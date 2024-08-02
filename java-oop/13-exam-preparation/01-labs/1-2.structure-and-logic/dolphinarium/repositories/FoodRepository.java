package dolphinarium.repositories;

import dolphinarium.entities.foods.Food;

//TODO Implement all methods
public interface FoodRepository {
    void add(Food food);

    boolean remove(Food food);

    Food findByType(String type);
}
