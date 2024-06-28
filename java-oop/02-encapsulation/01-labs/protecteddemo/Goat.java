package protecteddemo;

public class Goat extends Animal {

    public Goat(String name, int weight) {
        super(name, weight);
    }

    public String getMilk() {
        return getName() + " " + 13.4;
    }

    @Override
    protected String getName() {
        System.out.println("getName() from protecteddemo.Goat");
        return super.getName();
    }
}
