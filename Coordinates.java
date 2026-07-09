package Final_Assessment;

public class Coordinates {
    private int x;
    private int y;

    // Constructor with no parameters
    public Coordinates() {
        this.x = 0;
        this.y = 0;
        System.out.println("No coordinates entered, setting x and y to 0");
    }

    // Constructor to create new coordinate objects
    public Coordinates(int x, int y) {
        if (x >= 0) { // Ensuring x values cannot be negative
            this.x = x; // Setting the value of x in this object to what the user enters
        } else { // If x value is negative set x to 0
            this.x = 0;
            System.out.println("x value cannot be less than 0, setting x value to 0");
        }
        if (y >= 0) {
            this.y = y;
        } else {
            this.y = 0;
            System.out.println("y value cannot be less than 0, setting y value to 0");
        }
    }

    // Getter displaying x coordinate
    public int getX() {
        return this.x;
    }

    // Getter displaying y coordinate
    public int getY() {
        return this.y;
    }

    // distance method - Finding the distance between current coords and a point p
    public double distance(Coordinates p) {
        double x_diff = Math.pow(p.getX() - this.x, 2); // Calculating (x_2 - x_1)²
        double y_diff = Math.pow(p.getY() - this.y, 2); // Calculating (y_2 - y_1)²

        double sum = x_diff + y_diff; // Calculating (x_2 - x_1)² + (y_2 - y_1)²

        double distance = Math.sqrt(sum); // Finding the root of the sum
        return Math.round(distance * 1000.0) / 1000.0; // Formatring to 3d.p
    }

    // Translate method - Changing the values in x and y by dx and dy
    public void translate(int dx, int dy) {
        this.x += dx; // Updating current x value in the object by dx
        this.y += dy; // Updating current y value in the object by dy
    }

    // Scale method - Chnaging size based on factor
    public void scale(int factor, boolean sign) {
        // True = multiplication
        // False = division

        if (sign == true) { // Increases size
            this.x *= factor;
            this.y *= factor;
        } else { // Decreases size
            this.x /= factor;
            this.y /= factor;
        }
    }
    //Displaying Coordinate information
    public String display() {
        return "X = " + getX() + ", Y = " + getY();
    }
}
