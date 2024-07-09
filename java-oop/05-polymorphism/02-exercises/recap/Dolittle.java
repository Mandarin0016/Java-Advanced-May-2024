package recap;

public class Dolittle {

    public void healCat(Cat cat) {

        if (cat instanceof Lion) {
            ((Lion) cat).roar();
        }

        System.out.printf("%s has been healed and ready to run.\n", cat.getClass().getSimpleName());
        cat.run();
    }
}
