package shelf;

public class Main {

    public static void main(String[] args) {

        Shelf shelf = new Shelf("Apple", "Peach", "Orange", "Watermelon");

        for (String fruit : shelf) {
            System.out.println(fruit);
        }
    }
}
