package _07_Google;

public class Relative {

    private String name;
    private String birthday;

    public Relative(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {

        return String.format("%s %s", this.name, this.birthday);
    }
}
