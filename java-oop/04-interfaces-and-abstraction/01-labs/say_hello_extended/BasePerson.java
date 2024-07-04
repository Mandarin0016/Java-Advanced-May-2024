package say_hello_extended;

public abstract class BasePerson implements Person {

    private String name;

    protected BasePerson(String name) {
        setName(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
