import java.util.stream.IntStream;

public class PermuteDeckOfCards {
    
    private static int[] output = new int[52];
    private static boolean[] used = new boolean[52];

    public static void main(String[] args) {
        int[] cards = IntStream.rangeClosed(1, 52)
                .toArray();
        
        permute(cards, 0);
    }

    private static void permute(int[] cards, int index) {
        if (index == cards.length) {
            for (int n : output) {
                System.out.print(n);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < cards.length; i++) {
            if (!used[i]) {
                used[i] = true;
                output[index] = cards[i];
                permute(cards, index + 1);
                used[i] = false;
            }
        }
    }
}
