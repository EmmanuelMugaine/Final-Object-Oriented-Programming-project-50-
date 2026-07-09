package Final_Assessment;

/**
 * Because the Triangle needs 3 points, one for each vertex, it deviates from
 * the patterns seen
 * in the other shape classes
 * Triangle
 */
public class Triangle extends Shape {
    /**
     * vertex1 is inherited from the shape class
     * vertex2 and 3 are the Triangle classes uniques fields
     */
    private Coordinates vertex2;
    private Coordinates vertex3;

    // Constructor to create new
    public Triangle(Coordinates vertex1, Coordinates vertex2, Coordinates vertex3) {
        super(3, vertex1); // vertex1 is used as the base coordinates because it is inherited
        this.vertex2 = vertex2; // Updating vertex2 with the value that is entered
        this.vertex3 = vertex3;
    }
    // Getters to display vertex2 and vertex3 coordinates
    //Displaying vertex2 corrdinates
    public Coordinates getVertex2() {
        return this.vertex2;
    }
    //Displaying vertex3 coordinates
    public Coordinates getVertex3() {
        return this.vertex3;
    }
    // Setters to change vertex 2 and vertex3 coordinates
    //Changing vertex2 coordinates
    public void setVertex2(Coordinates v) {
        this.vertex2 = v;
    }
    //Changing vertex3 coordinates
    public void setVertex3(Coordinates v) {
        this.vertex3 = v;
    }

    // Overriding methods in the Shape class

    /**
     * Triangle is the only class that overrides the translate method in the shape
     * class because
     * it has two additional coordinate values that also need to be translated by dx
     * and dy
     */
    @Override
    public void translate(int dx, int dy) {
        super.translate(dx, dy); // moves vertex1 (the inherited position)
        this.vertex2.translate(dx, dy);
        this.vertex3.translate(dx, dy);
    }

    // Overriding the scale values
    @Override
    public void scale(int factor, boolean sign) {
        super.scale(factor, sign); // scales vertex1

        // New vertex coords also have to get scaled
        this.vertex2.scale(factor, sign);
        this.vertex3.scale(factor, sign);
    }

    // Calculating the perimeter by overriding the perimeter method in the shape
    // class
    /**
     * In order to calculate perimeter the distance between each vertex has to be
     * found
     * This is done by calling the distance() method to find the distances between
     * each
     * of the three vertices
     */
    @Override
    public double getPerimeter() {
        Coordinates v1 = getCoordinates();
        double a = v1.distance(vertex2); // Finding distance from vertex1 -> vertex2
        double b = vertex2.distance(vertex3); // Finding distance from vertex2 -> vertex3
        double c = vertex3.distance(v1); // Finding distance from vertex3 -> vertex1
        return a + b + c;
    }

    // Overriding the getArea of() method to calculate the area of the triangle
    /**
     * Using Heron's formula to calculate area of a triangle.
     * Formula: √s * (s − a) * (s − b) * (s − c)
     * Where:
     * a,b and c -> distances between the vertices
     * s -> The semiperimeter value (Perimeter / 2)
     */
    @Override
    public double getArea() {
        Coordinates v1 = getCoordinates(); // Getting the coordinates of vertex1
        // Finding the values of a, b and c
        double a = v1.distance(vertex2);
        double b = vertex2.distance(vertex3);
        double c = vertex3.distance(v1);
        // Calculating the semiperimeter
        double s = (a + b + c) / 2; // semiperimeter

        // Putting everything together and using Heron's formula
        return Math.sqrt(s * (s - a) * (s - b) * (s - c)); // Heron's formula
    }

    // Displaying the Triangle information
    @Override
    public String display() {
        return "Triangle: Vertex1 " + getCoordinates().display()
                + ", Vertex2 " + vertex2.display()
                + ", Vertex3 " + vertex3.display()
                + ", Area = " + getArea()
                + ", Perimeter = " + getPerimeter();
    }
}
