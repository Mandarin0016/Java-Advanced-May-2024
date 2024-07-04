package demo;

// Когато един клас имплементира даден интерфейс, този клас е задължен
// да даде имплементация на ВСИЧКИ методи дефинариани в интерфейса.
public class Payment implements Payable, Discountable {

    // Това е имплементация от интерфейса Payable
    @Override
    public boolean payWithCard(double productCost, double cardBalance) {

        if (productCost > cardBalance) {
            return false;
        } else {
            return true;
        }
    }

    // Това е имплементация от интерфейса Cashable
    @Override
    public void payWithCash() {
        System.out.println("Cash collected!");
    }

    @Override
    public String generateDiscountCode() {
        return "90%_SUMMER_CODE_DISCOUNT";
    }
}
