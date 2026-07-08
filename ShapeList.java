package Final_Assessment;

import java.util.ArrayList;

/**
 * Stores a list of Shape objects and provides operations to
 * add, remove, inspect, translate, and scale them as a group.
 */
public class ShapeList {
    // Creating an array list that will hold all the lists of shapes entered
    private ArrayList<Shape> listOfShapes;

    // Constructor to create a new 'listofShapes' list
    public ShapeList() {
        this.listOfShapes = new ArrayList<>();
    }

    // Method to add a shape to the list
    public void addShape(Shape s) {
        this.listOfShapes.add(s);
    }

    // Method to check the number of shapes in the list
    public int getNumberOfShapes() {
        return this.listOfShapes.size();
    }

    /**
     * Due to the getShape and removeShape methods both needing a validity check to
     * ensure
     * their respective actions can take place
     * The isValidPosition method is used to prevent repeated blocks of code because
     * it holds
     * the validity check and can be called anytime.
     */
    private boolean isValidPosition(int pos) {
        /**
         * Checking is the list contains at least one value, so that the getShape method
         * and the isValidPosition don't return an error
         */
        return pos >= 0 && pos < this.listOfShapes.size();
    }

    // Method to identify a shape at a specific position
    public Shape getShape(int pos) {
        if (isValidPosition(pos)) {
            // If a position is valid, display the shape currently there
            return this.listOfShapes.get(pos);
        } else {
            // If a position isn't valid, display an error message and the invalid position
            System.out.println("No shape exists at position " + pos);
            return null;
        }
    }

    // Method to remove a shape
    public Shape removeShape(int pos) {
        if (isValidPosition(pos)) {
            // If a position is valid, remove the shape from there
            return this.listOfShapes.remove(pos);
        } else {
            // If a position isn't valid, display an error message and invalid position
            System.out.println("No shape exists at position " + pos);
            return null;
        }
    }

    // Calculating the area of the shape at that specific posiyion
    public double area(int pos) {
        Shape s = getShape(pos);
        // Using a conditional operator to aid in what will be returned
        // condition ? valueIfTrue : valueIfFalse;

        /**
         * Area will be displayed if s != null is true
         * -1 will be returned if false
         */
        return (s != null) ? s.getArea() : -1;
    }

    // Calculating perimeter of the shape at a specific location
    public double perimeter(int pos) {
        Shape s = getShape(pos);
        // Same logic is applied here
        return (s != null) ? s.getPerimeter() : -1;
    }

    /**
     * Translating the shape to a new position
     * Takes advantage of the fact that each shape class has its own translate
     * method
     * As such I use that method rather than creating a new one
     */
    public void translateShapes(int dx, int dy) {
        for (Shape s : listOfShapes) {
            s.translate(dx, dy); // Calling translate method in the specific shape's class
        }
    }

    /**
     * Scaling a shape based on factor
     * Because each class has its own scale method, I use that rather than creating
     * a new one
     */
    public void scale(int factor, boolean sign) {
        for (Shape s : listOfShapes) {
            s.scale(factor, sign);
        }
    }

    // Displaying final string information
    public String display() {
        // Rather than using multiple + symbols to concatenate, Use a for loop and
        // Stringbuilder
        StringBuilder sb = new StringBuilder(); // Creating a stringbuilder object
        for (int i = 0; i < listOfShapes.size(); i++) { // Appending values and formatting them
            sb.append(i).append(": ").append(listOfShapes.get(i).display()).append("\n");
        }
        return sb.toString();
    }
}