package cards1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CardSuit[] cardSuits = CardSuit.values();

        System.out.println("Card Suits:");
        for (CardSuit cardSuit : cardSuits) {
            int ordinal = cardSuit.ordinal();
            System.out.printf("Ordinal value: %d; Name value: %s\n", ordinal, cardSuit);
        }
    }
}
