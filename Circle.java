package Final_Assessment;

public class Circle extends Shape {
    // Radius is the only unique field that the circle class has
    private double radius;
    //Constructor for creating an new Circle object
    public Circle(Coordinates coord, double radius) {
        super(1, coord); // Assigning the circle 1 side
        this.radius = radius;
    }

    // getting the radius value of the circle
    public double getRadius() {
        return this.radius;
    }

    // Changing the radius value
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Overriding the abstract methods created in the Shape class

    // finding the Area of the circle
    @Override
    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    // Finding the perimeter
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    // Editing the scale of the circle
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign);
        if (sign) {
            this.radius *= factor;
        } else {
            this.radius /= factor;
        }
    }

    // Displaying the circle information
    @Override
    public String display() {
        return "Circle: " + getCoordinates().display()
                + ", Radius = " + this.radius
                + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter();
    }
}
