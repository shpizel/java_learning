package ru.yandex.java.course.second.lesson;

public class Circle extends Shape {

    private /* final */ double radius; // состояние

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
        radius = 5;
    }

    /*public*/ public double getArea() { // поведение
        return Math.PI * radius * radius;
    }

    static double getArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}