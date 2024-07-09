package recap;

public class Lion extends Cat {

    public void roar() {
        System.out.println("ROAR!!!");
    }

    // Method overriding = пренаписах имплементация на метод дефиниран в бащиният клас
    public void run() {
        System.out.println("Lions are running faster than normal cats.");
    }
}
