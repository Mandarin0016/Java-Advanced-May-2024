package p02_ExtendedDatabase;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Person[] elements;
    private int elementsCount = 0;
    private int index;


    public Database(Person... people) throws OperationNotSupportedException {
        this.elementsCount = people.length;
        this.setElements(people);
        this.index = elementsCount - 1;
    }

    // Ще тествам:
    // 1. Ако подам елемент, който е null -> грешка
    // 2. Ако подам човек, който НЕ Е null -> човека ще бъде последен в моят масив с хора, както и броят ще се увеличи с 1
    public void add(Person person) throws OperationNotSupportedException {
        if (person == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = person;
        this.elementsCount++;
    }

    // Ще тествам:
    // 1. Ако премахвам от празна база -> грешка
    // 2. Ако премахвам от пълна база -> броят на елементите намаля с 1
    public void remove() throws OperationNotSupportedException {
        try {
			this.elements[index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

    // Ще тествам:
    // 1. Ако извъкам метода на база с X хора –> връща масив с точно тези хора
    public Person[] getElements() {
        Person[] buffer = new Person[elementsCount];
        int bufferIndex = 0;

        for (Person person : elements) {
            if (person != null) {
                buffer[bufferIndex++] = person;
            }
        }

        return buffer;
    }

    // Ще тествам:
    // 1. Ако подам username със стойност null -> грешка
    // 2. Ако в базата от данни нямам такъв човек с такова име -> грешка
    // 3. Ако в базата от данни имам такъв човек с такова име –> получавам този човек
    public Person findByUsername(String username) throws OperationNotSupportedException {
        List<Person> people = new ArrayList<>();

        if (username == null) {
            throw new OperationNotSupportedException();
        }

        for (Person person : elements) {

            if (person == null) {
                continue;
            }

            if (person.getUsername().equals(username)) {
                people.add(person);
            }
        }

        if (people.size() != 1) {
            throw new OperationNotSupportedException();
        }

        return people.get(0);
    }

    // Ще тествам:
    // 1. Ако в базата от данни нямам такъв човек с такова ID -> грешка
    // 2. Ако в базата от данни имам такъв човек с такова ID –> получавам този човек
    public Person findById(long id) throws OperationNotSupportedException {
        List<Person> people = new ArrayList<>();

        for (Person person : elements) {

            if (person == null) {
                continue;
            }

            if (person.getId() == id) {
                people.add(person);
            }
        }

        if (people.size() != 1) {
            throw new OperationNotSupportedException();
        }

        return people.get(0);
    }

    private void setElements(Person... elements) throws OperationNotSupportedException {
        if (elements.length > 16 ||
                elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Person[16];
        int bufferIndex = 0;

        for (Person person : elements) {
            this.elements[bufferIndex++] = person;
        }

        this.index = elements.length - 1;
    }
}
