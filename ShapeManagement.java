package Final_Assessment;

import java.util.InputMismatchException;
//Importing scanner to read user inputs
import java.util.Scanner;

/**
 * This class will use a continous loop within the main method
 * The loop will end naturally and will not have break statements ending the
 * loop early
 * This complies with the assignment specification
 */
public class ShapeManagement {

    public static void main(String[] args) {
        ShapeList shapeList = new ShapeList();
        Scanner scanner = new Scanner(System.in);
        /**
         * //Boolean check that the loop looks at before each iteration
         * This makes sure the loop can end naturally
         */
        boolean running = true;

        // Creating the loop

        while (running) { // Condition on whether to continue or not
            // Displaying options available to the user
            System.out.println("\n-------- Shape Management Menu ---------\n");
            System.out.println("1: Add a shape");
            System.out.println("2: Remove a shape by position");
            System.out.println("3: Get information about a shape by position");
            System.out.println("4: Area and perimeter of a shape by position");
            System.out.println("5: Display information of all shapes");
            System.out.println("6: Translate all shapes");
            System.out.println("7: Scale all shapes");
            System.out.println("0: Quit program");
            System.out.print("Enter your choice (Choose from 0 - 7): ");
            /**
             * Creating the choice variable and assigning it the value 0 to exit a program
             * This is helpful incase the user doesn't enter an integer value, the program
             * will simply end
             */
            int choice = 0;

            /**
             * Trying to store user input in the choice variable
             * The block of code catches an InputMismatchException
             */
            try {
                choice = scanner.nextInt(); // User input is stored into the choice variable
            } catch (InputMismatchException e) {
                System.err.println("Only enter integer values: " + e);
            }
            /**
             * To reduce repeated blocks of code, switch and case statements are implemented
             * Rather than multiple If and elif statements
             * This also allow for a greater deal of flexibility in how code is handled
             */
            switch (choice) {
                case 1: // Add a shape
                    /**
                     * If option 1 is chosen, user is prompted to add one of the four shapes
                     * Selecting an option in the range moves the user to the next menu
                     * If the user chooses an option outside the selection an error message
                     * is displayed
                     */
                    System.out.println("Choose a shape to add (1 - 4):");
                    System.out.println("1: Rectangle  2: Square  3: Circle  4: Triangle");
                    int shapeChoice = 0;
                    try { // Preventing user from entering non-integer values
                        shapeChoice = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        running = false;
                        System.err.println("Only enter integer values: " + e);
                        break;
                    }
                    // On valid menu selection program continues into entering values for the Shape
                    switch (shapeChoice) {
                        case 1: // Rectangle is selected
                            // Displaying instructions to user
                            System.out.println("Enter x, y, width, length: ");
                            // Formatting menu and storing user input values
                            System.out.print("x = ");
                            int rx = scanner.nextInt();
                            System.out.print("y = ");
                            int ry = scanner.nextInt();
                            System.out.print("Width = ");
                            double width = scanner.nextDouble();
                            System.out.print("Length = ");
                            double length = scanner.nextDouble();
                            // Creating a shape with the values entered by the user
                            shapeList.addShape(new Rectangle(new Coordinates(rx, ry), width, length));
                            break; // returning back to the main menu

                        case 2: // Square is selected
                            System.out.println("Enter x, y, side: ");
                            // Formatting menu and storing user input values
                            System.out.print("x = ");
                            int sx = scanner.nextInt();
                            System.out.print("y = ");
                            int sy = scanner.nextInt();
                            System.out.print("Side = ");
                            double side = scanner.nextDouble();
                            // Creating a shape with the values entered by the user
                            shapeList.addShape(new Square(new Coordinates(sx, sy), side));
                            break; // Returing to the main menu

                        case 3: // Circle is selected
                            System.out.println("Enter x, y, radius: ");
                            // Formatting menu and storing user input values
                            System.out.print("x = ");
                            int cx = scanner.nextInt();
                            System.out.print("y = ");
                            int cy = scanner.nextInt();
                            System.out.print("radius = ");
                            double radius = scanner.nextDouble();
                            // Creating a shape with the values entered by the user
                            shapeList.addShape(new Circle(new Coordinates(cx, cy), radius));
                            break; // Returing to the main menu

                        case 4: // If triangle is selected
                            System.out.println("Enter vertex1 x y, vertex2 x y, vertex3 x y: ");
                            System.out.print("Vertex 1 x: ");
                            int x1 = scanner.nextInt();
                            System.out.print("Vertex 1 y: ");
                            int y1 = scanner.nextInt();
                            System.out.print("Vertex 2 x: ");
                            int x2 = scanner.nextInt();
                            System.out.print("Vertex 2 y: ");
                            int y2 = scanner.nextInt();
                            System.out.print("Vertex 3 x: ");
                            int x3 = scanner.nextInt();
                            System.out.print("Vertex 3 y: ");
                            int y3 = scanner.nextInt();
                            // Creating a new triangle based on coords entered by the user
                            shapeList.addShape(new Triangle(
                                    new Coordinates(x1, y1),
                                    new Coordinates(x2, y2),
                                    new Coordinates(x3, y3)));
                            break; // Returning back to the main menu
                        default: // Incase user enters an invalid value
                            System.out.println("Invalid shape choice.");
                            break;
                    }
                    break;

                case 2: // Remove a shape by position in the list
                    /**
                     * This section works by removing a shape based on the sequence it was entered
                     * If user enteres: circle, rectangle , square and they remove position 2:
                     * Recatangle is removed and the sequence becomes: circle, square
                     * User input should start from 0 - represents the first index of the list
                     */
                    System.out.print("Enter position to remove (Enter 0 to remove the first shape created): ");
                    int removePos = 0;
                    try { // Preventing users from entering non-integer values
                        removePos = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("only enter integer values" + e);
                    }
                    // Accessing shapelist and removing value at the specified position
                    // This is done by calling the removeShape() method in shapelift
                    Shape removed = shapeList.removeShape(removePos);
                    if (removed != null) {
                        // Displaying information about the removed shape
                        System.out.println("Removed: " + removed.display());
                    }
                    break;

                case 3: // Get information about a shape by position
                    System.out.print("Enter position (Enter 0 for the first shape created): ");
                    int infoPos = 0;
                    try { // Preventing user from entering non-integer values
                        infoPos = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Only enter Integer values" + e);
                    }
                    // Calling shapelist to display information of the shape at the specified
                    // position
                    Shape s = shapeList.getShape(infoPos);
                    if (s != null) {
                        System.out.println(s.display());
                    }
                    break;

                case 4: // Area and Perimeter of a shape by position
                    System.out.print("Enter position (Enter 0 for the first shape created): ");
                    int apPos = 0;
                    try { // Preventing user from entering non-integer values
                        apPos = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Only enter Integer values" + e);
                    }
                    /**
                     * Calling shapelist to find the area and of the shape at the position
                     * This is done by Checking that the area value is valid, along with displaying
                     * The perimeter
                     */
                    double area = shapeList.area(apPos);
                    if (area != -1) {
                        System.out.printf("Area = %.3f%n", area);
                        System.out.printf("Perimeter = %.3f%n", shapeList.perimeter(apPos));
                    }
                    break;

                case 5: // Displaying information of all shapes
                    // First checks if there are actually shapes created and stored in the list
                    if (shapeList.getNumberOfShapes() == 0) {
                        // If no lists in shape, display a message to the user
                        System.out.println("No shapes in the list.");
                    } else { // If shapes are present, display their information
                        System.out.println(shapeList.display());
                    }
                    break;

                case 6: // Translate all shapes
                    // Displaying instructions to user
                    System.out.println("Enter dx and dy: ");
                    System.out.println("dx = change in x, dy = change in y");
                    System.out.print("dx = ");
                    int dx = scanner.nextInt();
                    System.out.print("dy = ");
                    int dy = scanner.nextInt();
                    // Translating all shapes based on user input
                    shapeList.translateShapes(dx, dy);
                    System.out.println("All shapes translated."); // Displaying success
                    break;

                case 7: // Scale all shapes
                    System.out.println("Enter factor (int) and sign (true=multiply, false=divide): ");
                    // Error handling for Factor
                    System.out.print("Enter the factor: ");
                    int factor = 0;
                    try { // Checking if factor = 0, to prevent zerodivisor error
                        factor = scanner.nextInt();
                        if (factor == 0) {
                            System.out.println("Factor value cannot be 0");
                            break; // Going back to main menu
                        }
                        // DIsplaying error information if user enters a non-integer value
                    } catch (InputMismatchException e) {
                        System.out.println("Only enter Integer values" + e);
                    }
                    // Error handling for Sign
                    System.out.print("Enter the sign: ");
                    boolean sign = true; // initialising sign with a placeholder value
                    try { // Checking if only a boolean value is entered in the field
                        sign = scanner.nextBoolean();
                        if (sign != true && sign != false) {
                            System.out.println("Only enter true or false for sign");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Only enter Boolean values for sign" + e);
                    }
                    // If fields entered are correct, all the shapes are scaled
                    shapeList.scale(factor, sign);
                    System.out.println("All shapes scaled."); // Success message
                    break;

                // Failsafe - Stops the programme from execuing again
                case 0:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                // Catching if the user enters a value that isn't 0-7
                default:
                    System.out.println("Invalid option, please try again.");
                    break;
            }
        }
        scanner.close(); // Closing scanner object to prevent resource wastage
    }
}
