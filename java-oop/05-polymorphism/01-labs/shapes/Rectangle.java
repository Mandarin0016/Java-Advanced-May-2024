package shapes;

public class Rectangle implements Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        return (height + width) * 2;
    }

    @Override
    public Double calculateArea() {
        return height * width;
    }
}
