package Final_Assessment;

public abstract class Shape extends Coordinates {
    // Shape class now has all the methods in the Coordinates class
    private int sides;
    private int x_position;
    private int y_position;

    // Constructor to input shape details
    Shape(int num_sides, int x_position, int y_position) {
        this.sides = num_sides;
        this.x_position = x_position;
        this.y_position = y_position;
    }

    // getCoordinates methods - To display current x and y values
    int getX() {
        return this.x_position;
    }

    int getY() {
        return this.y_position;
    }

    // getSides() method - Displaying number of sides for the shape
    int getSides() {
        return this.sides;
    }

    // setCoords methos - Changing the x and y values
    void setX(int new_x_coord) {
        this.x_position = new_x_coord;
    }

    void setY(int new_y_coord) {
        this.y_position = new_y_coord;
    }

    // Translate method - Changing the values in x and y by dx and dy
    void translate(int dx, int dy) {
        this.x_position += dx; // Updating current x value in the object by dx
        this.y_position += dy; // Updating current y value in the object by dy
    }

    // Scale method - Chnaging size based on factor
    void scale(int factor, boolean sign) {
        // True = multiplication
        // False = division

        if (sign == true) { // Increases size
            this.x_position *= factor;
            this.y_position *= factor;
        } else { // Decreases size
            this.x_position /= factor;
            this.y_position /= factor;
        }
    }

    // getArea() abstract method - Will be overwritten by children classes to find
    // their areas
    abstract double getArea();

    // getPerimeter() abstract method - Will be overwritten by children classes to
    // find their Perimeters
    abstract double getPerimeter();

    // display() abstact method - Will be used by children to display their coord
    // values
    abstract String display();
}
