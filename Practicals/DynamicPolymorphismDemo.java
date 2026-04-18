// package mypack;

// Interface
interface Shape {
    void area();
}

// Circle class implementing Shape
class Circle implements Shape {
    double r = 5;

    public void area() {
        System.out.println("Area of Circle = " + (3.14 * r * r));
    }
}

// Rectangle class implementing Shape
class Rectangle implements Shape {
    int l = 4, b = 6;

    public void area() {
        System.out.println("Area of Rectangle = " + (l * b));
    }
}

// Main class
public class DynamicPolymorphismDemo {
    public static void main(String[] args) {

        Shape s;  // Reference of interface

        // Dynamic Polymorphism
        s = new Circle();
        s.area();

        s = new Rectangle();
        s.area();
    }
}