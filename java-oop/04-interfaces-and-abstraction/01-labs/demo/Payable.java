package demo;

// Интерфейс = съвкупност от абстрактни методи и константни полета
// Интерфейс = договор
public interface Payable extends Cashable {

    // 1. Константни полета
    int MIN = 5;

    // 2. Метод дефиниции
    // Абстрактен метод = метод дефиниция без частта с имплементацията
    boolean payWithCard(double productCost, double cardBalance);
}
