package cards3;

public enum CardSuit {

    // Енъм стойности
    // Ordinal value -> поредна стойност/позиция на енъм стойността
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int power;

    // Конструктор -> създава нови обекти от класа!
    CardSuit(int power) {
        this.power = power;
    }

    public int getPower() {
        return this.power;
    }
}
