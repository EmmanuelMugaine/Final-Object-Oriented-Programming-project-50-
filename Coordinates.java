package Final_Assessment;

public class Coordinates {
    private int x;
    private int y;

    // Constructor with no parameters
    Coordinates() {
        this.x = 0;
        this.y = 0;
        System.out.println("No coordinates entered, setting x and y to 0");
    }

    // Constructor to create new coordinate objects
    Coordinates(int x, int y) {
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
    int getX() {
        return this.x;
    }

    // Getter displaying y coordinate
    int getY() {
        return this.y;
    }

    // distance method - Finding the distance current coords and a point p
    double distance(int x_2, int y_2) {
        double x_diff = Math.pow(x_2 - getX(), 2); // Calculating (x_2 - x_1)²
        double y_diff = Math.pow(y_2 - getY(), 2); // Calculating (y_2 - y_1)²

        double sum = x_diff + y_diff; // Calculating (x_2 - x_1)² + (y_2 - y_1)²

        double distance = Math.sqrt(sum); // Finding the root of the sum
        return Math.round(distance * 1000.0) / 1000.0; // Formatring to 3d.p
    }

    // Translate method - Changing the values in x and y by dx and dy
    void translate(int dx, int dy) {
        this.x += dx; // Updating current x value in the object by dx
        this.y += dy; // Updating current y value in the object by dy
    }

    // Scale method - Chnaging size based on factor
    void scale(int factor, boolean sign) {
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

    String display() {
        return "X = " + getX() + ", Y = " + getY();
    }
}

// Edit to make it display values well
class Main {
    public static void main(String[] args) {
        Coordinates coord = new Coordinates(10, 7);

    }
}

// Testing and displaying outputs class
class Tests {
    public static void main(String[] args) {
        Coordinates coord = new Coordinates(10, 7);
        coord.scale(2, false);

        System.out.println(coord.display());
    }
}
