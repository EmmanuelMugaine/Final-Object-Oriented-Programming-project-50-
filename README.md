# Shape Management System — IY4101 OOP final Assessment
 
A Java console application that models geometrical shapes (Rectangle, Square,
Circle, Triangle) using object-oriented principles, and lets a user add,
remove, inspect, translate, and scale a list of shapes through a menu.
 
## Overview
 
This program was built for IY4101 Practical Programming Assignment 2. It
demonstrates:
 
- Abstract classes and method overriding (`Shape`)
- Inheritance across a class hierarchy (`Rectangle`, `Square`, `Circle`,
  `Triangle` all extend `Shape`)
- Composition (`Shape` has a `Coordinates` object rather than extending it)
- Polymorphism (`ShapeList` stores and operates on `Shape` references without
  knowing the concrete subclass)
- Defensive programming (bounds-checking on list positions so invalid input
  does not crash the program)
