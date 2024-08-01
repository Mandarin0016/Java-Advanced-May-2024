public class Database {

    // MySQL, MariaDB
    private String type;
    private static Database instance = null;

    private Database() {

    }

    private Database(String type) {
        this.type = type;
    }

    public static Database getInstance(String type) {

        // Съществува ли вече такава инстанция
        if (instance != null) {
            return instance;
        }
        // instance == null
        Database database = new Database(type);
        instance = database;
        return database;
    }
}
