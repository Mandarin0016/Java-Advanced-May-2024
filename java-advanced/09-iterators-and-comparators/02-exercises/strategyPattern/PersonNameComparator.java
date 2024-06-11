package strategyPattern;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {


    @Override
    public int compare(Person firstPerson, Person secondPerson) {

        // Начин 1:
//        Integer firstNameLength = firstPerson.getName().length();
//        Integer secondNameLength = secondPerson.getName().length();
//        int nameLengthComparingResult = firstNameLength.compareTo(secondNameLength);

        // Начин 2:
        int nameLengthComparingResult = Integer.compare(firstPerson.getName().length(), secondPerson.getName().length());

        if (nameLengthComparingResult == 0) {
            char firstNameSymbol = firstPerson.getName().toUpperCase().charAt(0);// asen -> ASEN -> A
            char secondNameSymbol = secondPerson.getName().toUpperCase().charAt(0);// Asen -> ASEN -> A
            return Character.compare(firstNameSymbol, secondNameSymbol);
        }
        return nameLengthComparingResult;
    }
}
