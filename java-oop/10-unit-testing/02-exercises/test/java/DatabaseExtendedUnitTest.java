import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseExtendedUnitTest {

    // Ще тествам: add(Person person)
    // 1. Ако подам елемент, който е null -> грешка
    @Test
    public void whenTryToAddNullValue_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.add(null);
        });
    }

    // 2. Ако подам човек, който НЕ Е null -> човека ще бъде последен в моят масив с хора, както и броят ще се увеличи с 1
    @Test
    public void whenAddNonNullPerson_thenPersonIsAddedAtTheLastIndexAndCountIsIncrementedByOne() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);
        int initialPeopleCount = database.getElements().length; // 2

        Person peter = new Person(3, "Peter");
        database.add(peter);

        int newPeopleCount = database.getElements().length;
        Person lastPerson = database.getElements()[newPeopleCount - 1];

        // 1. Петър е последният човек в масива с хора
        Assertions.assertEquals(lastPerson, peter);
        // 2. Броят на хората се е увеличил с 1
        Assertions.assertEquals(newPeopleCount, initialPeopleCount + 1);
    }

    // Ще тествам:
    // 1. Ако премахвам от празна база -> грешка
    @Test
    public void whenTryToRemoveFromEmptyDatabase_thenExceptionIsThrown() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);

        database.remove();
        database.remove();

        Assertions.assertThrows(OperationNotSupportedException.class, () -> {
            database.remove();
        });
    }

    // 2. Ако премахвам от пълна база -> броят на елементите намаля с 1
    @Test
    public void whenTryToRemoveFromNonEmptyDataBase_thenPeopleCountDecrementByOne() throws OperationNotSupportedException {

        Person ivan = new Person(1, "Ivan");
        Person gosho = new Person(2, "Gosho");
        Person[] people = {ivan, gosho};

        Database database = new Database(people);
        int initialPeopleCount = database.getElements().length;
        database.remove();

        int newPeopleCount = database.getElements().length;
        Assertions.assertEquals(newPeopleCount, initialPeopleCount - 1);
    }

}
