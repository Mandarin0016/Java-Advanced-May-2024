package wildfarm;

public abstract class Mammal extends Animal {
    private final String livingRegion;

    protected Mammal(String name, String type, Double weight, String livingRegion) {
        super(name, type, weight);
        this.livingRegion = livingRegion;
    }
}
