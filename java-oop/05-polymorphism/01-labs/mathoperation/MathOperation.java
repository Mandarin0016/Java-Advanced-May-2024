package mathoperation;

public class MathOperation {

    private MathOperation() {
    }

    public static int add(int f, int s) {
        return f + s;
    }

    public static int add(int f, int s, int t) {
        return add(add(f, s), t);
    }

    public static int add(int f, int s, int t, int fth) {
        return add(add(f, s), add(t, fth));
    }

}
