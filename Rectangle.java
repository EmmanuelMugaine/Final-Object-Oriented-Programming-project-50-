package Final_Assessment;

/**
 * The rectangle class is a child to the shape class
 * It is a concrete class, whose area and perimeter can be found
 */
public class Rectangle extends Shape {
    private double length;
    private double width;

    // Constructor for creating new rectangle objects
    /**
     * @super Calls the parent object and creates a shape with 4 sides
     */
    public Rectangle(Coordinates coord, double length, double width) {
        super(4, coord);
        this.width = width;
        this.length = length;
    }

    // Getters to display length and width values
    public double getLength() {
        return this.length;
    }

    public double getWidth() {
        return this.width;
    }

    // Setters to change current length and width values
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // Overriding abstract methods in the Shape class

    // Finding the area of the rectangle
    @Override
    public double getArea() {
        return this.length * this.width;
    }

    // Finding the Perimeter
    @Override
    public double getPerimeter() {
        return (this.length + this.width) * 2;
    }

    // Displaying Shape information
    @Override
    public String display() {
        return "Rectangle: " + getCoordinates().display() // This is called from the coordinates class
                + ", Width = " + this.width
                + ", Length = " + this.length
                + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter();
    }

    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign); // scales the position via Shape -> Coordinates
        if (sign) {
            this.width *= factor;
            this.length *= factor;
        } else {
            this.width /= factor;
            this.length /= factor;
        }
    }
}
