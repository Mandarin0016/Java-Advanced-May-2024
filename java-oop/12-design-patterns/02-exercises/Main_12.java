public class Main_12 {

    public static void main(String[] args) {

        // Singleton = един клас може да има само 1 инстанция
        // private Constructor
        // static method getInstance
        Database mysql = Database.getInstance("MySQL");
        Database mariaDB = Database.getInstance("MariaDB");
        System.out.println();

    }
}
