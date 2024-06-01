package demo;

public class Main {

    public static void main(String[] args) {

        Book harryPotter = new Book("Harry Potter", "J.K.Rowling", 25.30);

        //harryPotter.title = "Bai Ganio"; // ТОВА НЕ Е ДОБРА ПРАКТИКА
        harryPotter.setTitle("Bai Ganio");

        System.out.println(harryPotter.getTitle());

        harryPotter.sell();
    }
}
