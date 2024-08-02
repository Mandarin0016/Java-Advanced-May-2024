package wildfarm;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type,
               Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }


}
