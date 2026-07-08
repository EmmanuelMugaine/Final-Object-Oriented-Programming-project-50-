package Final_Assessment;

/**
 * Abstract base class representing a general geometrical shape.
 * A Shape has a position (a Coordinates object) and a number of sides.
 * It has no area or perimeter of its own - those are defined by
 * whatever concrete shape (Rectangle, Square, Circle, Triangle)
 * extends this class.
 */

public abstract class Shape {

    // Shape HAS a Coordinates object (composition), it does not extend it.
    private Coordinates position;
    private int sides;

    /**
     * Creates a Shape with the given number of sides at the given position.
     *
     * noOfSides - the number of sides the shape has
     * coord - the Coordinates object representing the shape's position
     */
    public Shape(int noOfSides, Coordinates coord) {
        this.sides = noOfSides;
        this.position = coord;
    }

    /**
     * return the Coordinates object representing this shape's position
     */
    public Coordinates getCoordinates() {
        return this.position;
    }

    /**
     * return the number of sides this shape has
     */
    public int getSides() {
        return this.sides;
    }

    /**
     * Replaces this shape's position with a new Coordinates object.
     *
     * newCoord - the new position for this shape
     */
    public void setCoordinates(Coordinates newCoord) {
        this.position = newCoord;
    }

    /**
     * Moves this shape by dx and dy.
     * Delegates to the Coordinates object's own translate() method,
     * since Shape holds a Coordinates rather than raw x/y values.
     * Triangle overrides this method, since it must move three
     * vertices rather than just one position.
     *
     * dx - the amount to move in the x direction
     * dy - the amount to move in the y direction
     */
    public void translate(int dx, int dy) {
        this.position.translate(dx, dy);
    }

    /**
     * Scales this shape's position by the given factor.
     * Every subclass overrides this method as well, because scaling a
     * shape also means scaling its own attributes (radius, width,
     * length, side, or extra vertices) - not just its position.
     *
     * factor - the value to multiply or divide by
     * sign - true to multiply (grow), false to divide (shrink)
     */
    public void scale(int factor, boolean sign) {
        this.position.scale(factor, sign);
    }

    /**
     * Calculates the area of the shape.
     * Must be implemented by every subclass, since a general
     * Shape has no defined area of its own.
     *
     * return the area of the shape
     */
    public abstract double getArea();

    /**
     * Calculates the perimeter of the shape.
     * Must be implemented by every subclass, since a general
     * Shape has no defined perimeter of its own.
     *
     * return the perimeter of the shape
     */
    public abstract double getPerimeter();

    /**
     * Returns a string describing the shape: its name, its
     * attributes, and its area and perimeter.
     * Must be implemented by every subclass.
     *
     * return a formatted description of the shape
     */
    public abstract String display();
}
