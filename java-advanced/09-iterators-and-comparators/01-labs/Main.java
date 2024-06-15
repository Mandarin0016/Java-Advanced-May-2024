import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookThree = new Book("The Documents in the Case", 2002);
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

        Collections.sort(books);

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            System.out.println(b.getTitle() + b.getYear());
        }

        for (Book b : books) {
            System.out.println(b.getTitle() + b.getYear());
        }

        books.sort(new BookComparator());

        for (Book b : books) {
            System.out.println(b.getTitle() + b.getYear());
        }

        books.sort((f, s) -> Integer.compare(s.getYear(), f.getYear()));

        for (Book b : books) {
            System.out.println(b.getTitle() + b.getYear());
        }
    }
}
