import java.util.Scanner;

interface Shape {
    double area();
}

class Rectangle implements Shape {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }
}

class Triangle implements Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }
}

public class ShapeTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of rectangle: ");
        double l = sc.nextDouble();

        System.out.print("Enter width of rectangle: ");
        double w = sc.nextDouble();

        Rectangle r = new Rectangle(l, w);
        System.out.println("Area of Rectangle: " + r.area());

        System.out.print("Enter base of triangle: ");
        double b = sc.nextDouble();

        System.out.print("Enter height of triangle: ");
        double h = sc.nextDouble();

        Triangle t = new Triangle(b, h);
        System.out.println("Area of Triangle: " + t.area());
    }
}