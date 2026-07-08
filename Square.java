package Final_Assessment;

public class Square extends Shape {

    private double side;

    // Constructor for creating new square objects
    /**
     * @super Calls the parent object and creates a shape with 4 sides
     */
    public Square(Coordinates coord, double side) {
        super(4, coord);
        this.side = side;
    }

    // getting side value
    public double getSide() {
        return this.side;
    }

    // Changing side value
    public void setSide(double side) {
        this.side = side;
    }

    // Overriding abstract methods in the shape class
    // Calculating the area of the square
    @Override
    public double getArea() {
        return this.side * this.side;
    }

    // Calculating the perimeter of the square
    @Override
    public double getPerimeter() {
        return 4 * this.side;
    }

    // Editing the scale factor of the square
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.side *= factor;
        } else {
            this.side /= factor;
        }
    }

    // Displaying the shape information
    @Override
    public String display() {
        return "Square: " + getCoordinates().display()
                + ", Side = " + this.side
                + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter();
    }
}