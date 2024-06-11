package comparingObjects;

public class Person implements Comparable<Person> {

    private String name;
    private Integer age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person otherPerson) {

        // 1. Сравнение по име
        int nameComparingResult = this.name.compareTo(otherPerson.getName());
        // 2. Сравнение по години
        int ageComparingResult = this.age.compareTo(otherPerson.getAge());
        // 3. Сравнение по град
        int townComparingResult = this.town.compareTo(otherPerson.getTown());

        // Ако резултата при сравнението на две характеристики е 0, то означава че двете характеристики са еднакви
        // Ако резултата при сравнението на две характеристики е РАЗЛИЧЕН от 0, то означава че двете характеристики са РАЗЛИЧНИ

        if (nameComparingResult != 0) {
            return nameComparingResult;
        } else if (ageComparingResult != 0) {
            return ageComparingResult;
        } else {
            return townComparingResult;
        }
    }
}
