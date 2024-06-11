package strategyPattern;

import java.util.Comparator;

// Comparator -> Външен клас, който пази логика за сравнение да два обекта от един и същи тип
public class PersonAgeComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
    }
}
