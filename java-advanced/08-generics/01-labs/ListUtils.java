import java.util.Collections;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        ensureNotEmpty(list);
        return Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        ensureNotEmpty(list);
        return Collections.max(list);
    }

    private static <T> void ensureNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            IllegalArgumentException exception = new IllegalArgumentException("Empty list");
            throw exception;
        }
    }

}
