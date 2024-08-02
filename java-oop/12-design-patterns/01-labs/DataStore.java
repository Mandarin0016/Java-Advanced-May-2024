import java.util.ArrayList;
import java.util.List;

public class DataStore {

    private static final List<String> DATA = new ArrayList<>();

    private static DataStore instance;

    private List<String> data;

    private DataStore(List<String> data) {
        // slow and risky operation
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }

        this.data = data;
    }

    public static DataStore getInstance() {
        // Lazy init
        if (instance == null) {
            // costs something
            instance = new DataStore(DATA);
        }
        return instance;
    }

    public String getAllStrings() {
        return String.join(" ", data);
    }

    public void writeString(String str) {
        data.add(str);
    }

}
