import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        DataStore store = DataStore.getInstance();

        store.writeString("The quick");
        DataStore store1 = DataStore.getInstance();
        store1.writeString("brown fox");
        DataStore store2 = DataStore.getInstance();
        store2.writeString("jumps");
        DataStore store3 = DataStore.getInstance();
        store3.writeString("over");
        DataStore store4 = DataStore.getInstance();
        store4.writeString("the lazy");
        DataStore store5 = DataStore.getInstance();
        store5.writeString("dog");

        System.out.println(store.getAllStrings());

        StringBuilder builder = new StringBuilder();

        Address address = Address.builder()
                .setName("Pesho")
                .setEmail("Pesho@abv.bg")
                .build();

    }
}
