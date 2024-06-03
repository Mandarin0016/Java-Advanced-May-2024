package _01_OpinionPoll;

public class Person {

    //характеристики
    private String name;
    private int age;

    //конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Връща стойността на полето name
    public String getName() {
        return name;
    }

    //Връща стойността на полето age
    public int getAge() {
        return age;
    }

    //Връща стойността на обект от този клас във формата на String
    @Override
    public String toString() {
        //връща обектът под формата на текст
        //обект = тескт "{name} - {age}"
        return name + " - " + age;
    }
}
