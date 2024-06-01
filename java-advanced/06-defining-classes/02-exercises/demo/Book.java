package demo;

public class Book {

    // 1. Fields: винаги са private
    private String title;
    private String author;
    private double price;

    // 2. Constructor: creates new objects
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // 3. Methods: actions
    public void sell() {
        System.out.printf("Book with title %s was sold for %.2f", this.title, this.price);
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public String getTitle() {
        return this.title;
    }
}
