public class Printer<T> {

    private T toPrint;

    public Printer(T toPrint) {
        this.toPrint = toPrint;
    }

    public T print() {
        System.out.println(toPrint);
        return toPrint;
    }

}
