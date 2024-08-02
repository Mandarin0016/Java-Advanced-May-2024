package shapes;

public class Main {
    public static void main(String[] args) {
        printShape(new Circle(13.20));
        printShape(new Rectangle(2D, 4D));
        printShape(new Square(3D));
    }

    public static void printShape(Shape shape) {
        System.out.printf("Shape with area %.2f and perimeter %.2f%n",
                shape.calculateArea(), shape.calculatePerimeter());
    }
}
