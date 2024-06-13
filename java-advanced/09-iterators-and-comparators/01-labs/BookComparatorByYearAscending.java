import java.util.Comparator;

public class BookComparatorByYearAscending implements Comparator<Book> {
    @Override
    public int compare(Book f, Book s) {
        return f.getYear() - s.getYear();
    }
}
