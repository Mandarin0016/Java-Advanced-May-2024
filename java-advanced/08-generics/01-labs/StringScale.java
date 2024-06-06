public class StringScale {

    private String left;
    private String right;

    public StringScale(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getHeavier() {
        int result = left.compareTo(right);

        if (result > 0) {
            return left;
        } else if (result < 0 ) {
            return right;
        }

        return left;
    }

}
