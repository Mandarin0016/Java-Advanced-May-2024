package comparingObjects;

// Comparable -> обектите от този клас да бъдат СРАВНИМИ
public class Person implements Comparable<Person> {

    private String name;
    private String town;
    private Integer age;

    public Person(String name, String town, Integer age) {
        this.name = name;
        this.town = town;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getTown() {
        return town;
    }

    public Integer getAge() {
        return age;
    }

    // Начина по който ние сравняваме двама човека
    @Override
    public int compareTo(Person otherPerson) {

        // Отговор при сравнение:
        // 0 = еднакви стойности
        // 1 = различни стойности
        // -1 = различни стойности

        // 1. Сравнение по име
        int nameComparingResult = this.name.compareTo(otherPerson.name);
        // 2. Сравнение по години
        int ageComparingResult = this.age.compareTo(otherPerson.age);
        // 3. Сравнение по град
        int townComparingResult = this.town.compareTo(otherPerson.town);

        if (nameComparingResult != 0) {
            return nameComparingResult;
        } else if (ageComparingResult != 0) {
            return ageComparingResult;
        } else {
            return townComparingResult;
        }
    }
}
