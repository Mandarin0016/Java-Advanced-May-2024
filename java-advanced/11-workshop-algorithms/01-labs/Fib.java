public class Fib {

    private static long[] memory = new long[51];

    public static void main(String[] args) {
        int n = 50;

        long result = F(n);

        System.out.println(result);
    }

    private static long F(int n) {
        if (n <= 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = F(n - 1) + F(n - 2);
    }

}
