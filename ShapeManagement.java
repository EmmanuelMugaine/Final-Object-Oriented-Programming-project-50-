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
                case 1:
                    /**
                     * If option 1 is chosen, user is prompted to add one of the four shapes
                     * Selecting an option in the range moves the user to the next menu
                     * If the user chooses an option outside the selection an error message
                     * is displayed
                     */
                    System.out.println("Choose a shape to add (1 - 4):");
                    System.out.println("1: Rectangle  2: Square  3: Circle  4: Triangle");
                    int shapeChoice = 0;
                    try {
                        shapeChoice = scanner.nextInt();
                    } catch (InputMismatchException e) {
                        running = false;
                        System.err.println("Only enter integer values: " + e);
                        break;
                    }
                    // On valid menu selection program continues into entering values for the Shape
                    switch (shapeChoice) {
                        case 1:
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

                        case 2:
                            System.out.println("Enter x, y, side: ");
                            int sx = scanner.nextInt();
                            int sy = scanner.nextInt();
                            double side = scanner.nextDouble();
                            shapeList.addShape(new Square(new Coordinates(sx, sy), side));
                            break;
                        case 3:
                            System.out.print("Enter x, y, radius: ");
                            int cx = scanner.nextInt();
                            int cy = scanner.nextInt();
                            double radius = scanner.nextDouble();
                            shapeList.addShape(new Circle(new Coordinates(cx, cy), radius));
                            break;
                        case 4:
                            System.out.print("Enter vertex1 x y, vertex2 x y, vertex3 x y: ");
                            int x1 = scanner.nextInt();
                            int y1 = scanner.nextInt();
                            int x2 = scanner.nextInt();
                            int y2 = scanner.nextInt();
                            int x3 = scanner.nextInt();
                            int y3 = scanner.nextInt();
                            shapeList.addShape(new Triangle(
                                    new Coordinates(x1, y1),
                                    new Coordinates(x2, y2),
                                    new Coordinates(x3, y3)));
                            break;
                        default:
                            System.out.println("Invalid shape choice.");
                            break;
                    }
                    break;

                case 2:
                    System.out.print("Enter position to remove: ");
                    int removePos = scanner.nextInt();
                    Shape removed = shapeList.removeShape(removePos);
                    if (removed != null) {
                        System.out.println("Removed: " + removed.display());
                    }
                    break;

                case 3:
                    System.out.print("Enter position: ");
                    int infoPos = scanner.nextInt();
                    Shape s = shapeList.getShape(infoPos);
                    if (s != null) {
                        System.out.println(s.display());
                    }
                    break;

                case 4:
                    System.out.print("Enter position: ");
                    int apPos = scanner.nextInt();
                    double area = shapeList.area(apPos);
                    if (area != -1) {
                        System.out.println("Area = " + area);
                        System.out.println("Perimeter = " + shapeList.perimeter(apPos));
                    }
                    break;

                case 5:
                    if (shapeList.getNumberOfShapes() == 0) {
                        System.out.println("No shapes in the list.");
                    } else {
                        System.out.println(shapeList.display());
                    }
                    break;

                case 6:
                    System.out.print("Enter dx and dy: ");
                    int dx = scanner.nextInt();
                    int dy = scanner.nextInt();
                    shapeList.translateShapes(dx, dy);
                    System.out.println("All shapes translated.");
                    break;

                case 7:
                    System.out.print("Enter factor (int) and sign (true=multiply, false=divide): ");
                    int factor = scanner.nextInt();
                    boolean sign = scanner.nextBoolean();
                    shapeList.scale(factor, sign);
                    System.out.println("All shapes scaled.");
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