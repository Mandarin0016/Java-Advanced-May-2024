public class IntegerScale {

    private Integer left;
    private Integer right;

    public IntegerScale(Integer left, Integer right) {
        this.left = left;
        this.right = right;
    }

    public Integer getHeavier() {
        int result = left.compareTo(right);

        if (result > 0) {
            return left;
        } else if (result < 0 ) {
            return right;
        }

        return left;
    }

}
