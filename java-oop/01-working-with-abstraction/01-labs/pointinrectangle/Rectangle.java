package pointinrectangle;

public class Rectangle {
    private final Point a;
    private final Point b;

    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public boolean contains(Point p) {
        return p.getX() >= a.getX() && p.getX() <= b.getX()
                && p.getY() >= a.getY() && p.getY() <= b.getY();
    }
}
