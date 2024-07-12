package recap.OC;

import java.util.List;

// Modification
public class Farm {

    private List<Animal> animals;

    public void walkAnimals() {

        for (Animal animal : animals) {

            animal.walk();
        }
    }
}
