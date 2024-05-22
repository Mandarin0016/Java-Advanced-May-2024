import java.util.*;

public class _07_HandsOfCards {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {

            //Peter: 2C, 4H, 9H, AS, QS
            String name = input.split(": ")[0];
            String[] cards = input.split(": ")[1].split(", "); // ["2C", "4H", "9H", "AS", "QS"]

            // 1. Имам ли информация за тесте с карти за това име
            // Ако имам:
            if (playerCards.containsKey(name)) {
                // -> Вземам досегаяшното тесте с карти и към него добавям тези, които сега е изтеглил
                playerCards.get(name).addAll(List.of(cards));
            }
            // Ако нямам:
            else {
                // -> Нов запис за този играч с празно тесте от карти
                playerCards.put(name, new HashSet<>());
                // -> Към това празно тест добавям тези, които сега е изтеглил
                playerCards.get(name).addAll(List.of(cards));
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playerCards.entrySet()) {

            String playerName = entry.getKey();
            Set<String> cards = entry.getValue();

            int totalCardsValue = calculateTotalValue(cards);

            System.out.printf("%s: %d\n", playerName, totalCardsValue);
        }
    }

    private static int calculateTotalValue(Set<String> cards) {

        int sum = 0;
        for (String card : cards) {
            // PT
            // value = power * type
            int cardValue;
            if (card.startsWith("10")) {
                // 10H
                char cardType = card.charAt(2);
                cardValue = 10 * getNumberBySymbol(cardType);
            } else {
                // 3H
                char cardPower = card.charAt(0);
                char cardType = card.charAt(1);
                cardValue = getNumberBySymbol(cardPower) * getNumberBySymbol(cardType);
            }
            sum += cardValue;
        }
        return sum;
    }

    private static int getNumberBySymbol(char symbol) {

        int number = 0;

        switch (symbol) {
            case '2' -> number = 2;
            case '3' -> number = 3;
            case '4' -> number = 4;
            case '5' -> number = 5;
            case '6' -> number = 6;
            case '7' -> number = 7;
            case '8' -> number = 8;
            case '9' -> number = 9;
            case 'J' -> number = 11;
            case 'Q' -> number = 12;
            case 'K' -> number = 13;
            case 'A' -> number = 14;
            case 'S' -> number = 4;
            case 'H' -> number = 3;
            case 'D' -> number = 2;
            case 'C' -> number = 1;
        }

        return number;
    }
}
