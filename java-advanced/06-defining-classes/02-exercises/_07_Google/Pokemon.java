package _07_Google;

public class Pokemon {

    private String name;
    private String type;

    public Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.name, this.type);
    }
}
