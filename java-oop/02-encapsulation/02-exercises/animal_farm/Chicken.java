package animal_farm;

public class Chicken {

    private String name;
    private int age;

    public Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        //Validate the chicken’s name (it cannot be null, empty, or whitespace).
        //In case of an invalid name, print the exception message "Name cannot be empty."
        // name = "";
        // name = "   ";
        // name.isBlank() -> ако името е изградено само от интервали/спейсове
        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        //Validate the age properly, minimum and maximum age are provided, make use of them.
        //In case of invalid age, print the exception message "Age should be between 0 and 15."
        // [0-15]
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    // Получавам информация за яйца за 1 ден
    public double productPerDay() {
        return calculateProductPerDay();
    }

    // Пресмятам колко яйца на ден снася моето пиле
    private double calculateProductPerDay() {
        //First 6 years it produces 2 eggs per day [0 - 5].
        //Next 6 years it produces 1 egg per day [6 - 11].
        //And after that, it produces 0.75 eggs per day.
        if (age <= 5) {
            return 2;
        } else if (age <= 11) {
            return 1;
        } else {
            return 0.75;
        }
    }

    public String toString() {
        return String.format("Chicken %s (age %d) can produce %.2f eggs per day.", name, age, productPerDay());
    }
}
