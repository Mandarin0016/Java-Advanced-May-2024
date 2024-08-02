package shapes;

public class Square implements Shape {
    private Double side;

    public Square(Double side) {
        this.side = side;
    }

    @Override
    public Double calculatePerimeter() {
        return (side + side) * 2;
    }

    @Override
    public Double calculateArea() {
        return side * side;
    }
}
