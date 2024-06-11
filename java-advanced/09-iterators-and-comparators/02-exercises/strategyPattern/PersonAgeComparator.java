package strategyPattern;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {


    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        return firstPerson.getAge().compareTo(secondPerson.getAge());
    }
}
