import java.util.Scanner;

public class _06_RecursiveFibonacci {

    private static long[] fibonacciMemory;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        fibonacciMemory = new long[n + 1];

        long fibonacci = getFibonacci(n);

        System.out.println(fibonacci);
    }

    private static long getFibonacci(int n) {

        // Дъно
        if (n <= 1) {
            return 1;
        } else {

            if (fibonacciMemory[n] != 0) {
                return fibonacciMemory[n];
            }

            long fib = getFibonacci(n - 1) + getFibonacci(n - 2);
            fibonacciMemory[n] = fib;

            return fib;
        }
    }
}
