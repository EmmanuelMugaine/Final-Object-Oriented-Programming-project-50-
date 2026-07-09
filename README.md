# Shape Management System — IY4101 OOP final Assessment
 
A Java console application that models geometrical shapes (Rectangle, Square,
Circle, Triangle) using object-oriented principles, and lets a user add,
remove, inspect, translate, and scale a list of shapes through a menu.
 
## Overview
 
This program was built for IY4101 Practical Programming Assignment 2. It
demonstrates:
 
- Abstract classes and method overriding (**Shape**)
- Inheritance across a class hierarchy (**Rectangle, Square, Circle,
  Triangle** *all extend* **Shape**)
- Composition (**Shape** has a **Coordinates** object rather than extending it)
- Polymorphism (**ShapeList** stores and operates on **Shape** references without
  knowing the concrete subclass)
- Defensive programming (bounds-checking on list positions so invalid input
  does not crash the program)

## Class structure
 
| Class | Purpose |
|---|---|
| **Coordinates** | Represents an (x, y) point; provides distance, translate, scale, display |
| **Shape** (abstract) | Base class for all shapes; holds a position and side count; declares `getArea()`, `getPerimeter()`, `display()` as abstract |
| **Rectangle, Square, Circle** | Concrete shapes; each overrides `getArea()`, `getPerimeter()`, `scale()`, `display()` |
| **Triangle** | Concrete shape with three vertices; overrides `translate()` and `scale()` in addition to the above, since it must move/scale all three points |
| **ShapeList** | Stores shapes in an `ArrayList<Shape>`; provides add/remove/get/area/perimeter/translate/scale/display operations, with bounds-checking on position-based methods |
| **ShapeManagement** | Console entry point; runs the menu loop and calls the appropriate `ShapeList` method for each option |
