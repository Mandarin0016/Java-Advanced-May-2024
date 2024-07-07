package recap.interfaces;

public class Main {

    public static void main(String[] args) {

        Payable payable1 = new CreditCardPayment();
        Payable payable2 = new DebitCardPayment();
        Payable payable3 = new BankTransferPayment();

        payable1.pay();
        payable2.pay();
        payable3.pay();


    }
}
