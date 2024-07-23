package p01_Database;

import javax.naming.OperationNotSupportedException;

public class Database {

    private Integer[] elements;
    private int elementsCount = 0;
    private int index;

    // Ще тествам:
    // 1. Ако броят на елементите е 0 -> грешка и не създавам база от данни
    // 2. Ако броят на елементите е по-голям от 16 -> грешка и не създавам база от данни
    // 3. Ако броят на елементите е между 1 и 16 -> успешно създавам база от данни
    public Database(Integer... elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;
        this.setElements(elements);
        this.index = elementsCount - 1;
    }

    // Ще тествам:
    // 1. Ако подам елемент, който е null -> грешка
    // 2. Ако подам валидно число -> числото ще бъде последното в моят масив с елементи, както и броят ще се увеличи с 1
    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = element;
        this.elementsCount++;
    }

    // Ще тествам:
    // 1. Ако премахвам от празна база -> грешка
    // 2. Ако премахвам от пълна база -> броят на елементите намаля с 1
    public void remove() throws OperationNotSupportedException {
		try {
            // remove {11, 15, 16}
            // index = 2
            // remove {11, 15}
            // index = 1
            // remove {11}
            // index = 0
            // remove {} РЕЗУЛТАТА ЩЕ Е ГРЕШКА = ArrayIndexOutOfBoundsException
            // index = -1
			this.elements[index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

    // Ще тествам:
    // 1. Ако извъкам метода на база с X елемента –> връща масив с точно тези елементи
    public Integer[] getElements() {
        Integer[] buffer = new Integer[elementsCount];
        int bufferIndex = 0;

        for (Integer element : elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    // Когато запазвам числата в базата от данни:
    // 1. Ако броят на числата е извън позволените граници -> грешка
    // 2. Ако броят на числата е в позволените граници -> тогава успешно създавам база от данни с тези числа
    private void setElements(Integer... elements) throws OperationNotSupportedException {
        if (elements.length > 16 ||
                elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Integer[16];
        int bufferIndex = 0;

        for (Integer element : elements) {
            this.elements[bufferIndex++] = element;
        }

        this.index = elements.length - 1;
    }
}
