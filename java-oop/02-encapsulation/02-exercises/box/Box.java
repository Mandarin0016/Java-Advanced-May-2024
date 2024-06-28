package box;

public class Box {

    private double length;
    private double width;
    private double height;

    // Ако една от страните е число <= 0 --> невалидно
    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        // Валидация
        if (length <= 0) {
            // Хвърлям грешка при валидацията и спирам изпълнението на програмата
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        // Валидация
        if (width <= 0) {
            // Хвърлям грешка при валидацията и спирам изпълнението на програмата
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        // Валидация
        if (height <= 0) {
            // Хвърлям грешка при валидацията и спирам изпълнението на програмата
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        //Surface Area = 2lw + 2lh + 2wh
        return 2 * length * width + 2 * length * height + 2 * width * height;
    }

    public double calculateLateralSurfaceArea() {
        //Lateral Surface Area = 2lh + 2wh
        return 2 * length * height + 2 * width * height;
    }

    public double calculateVolume() {
        //Volume = lwh
        return length * width * height;
    }
}
