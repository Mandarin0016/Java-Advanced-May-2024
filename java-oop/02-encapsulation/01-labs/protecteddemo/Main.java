package protecteddemo;

public class Main {
    public static void main(String[] args) {
        Goat goat = new Goat("Coka", 15);
        // Bad practice to access protected
        // class member from non-inherited context
        System.out.println(goat.getName());

        System.out.println(goat.getMilk());
    }
}
