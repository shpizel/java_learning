package ru.java.course.second;

public class Rectangle extends Shape {
    public final double a;
    public final double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getArea() {
        return a * b;
    }
}
