package ru.java.course.second;

public class Presentation {
    public static void main(String[] args) {
        /**
         * Class (класс)
         * - name (поле)
         * - students (поле)
         *
         * Student (класс)
         * - name (поле)
         * - age (поле)
         *
         * Полиморфизм
         * Наследование
         * Инкапсуляция
         */

        Shape circle1 = new Circle();
//        System.out.println(circle1.getArea());

        Shape circle2 = new Circle(10);
//        System.out.println(circle2.getArea());

        Shape rectangle1 = new Rectangle(1, 2);
        Shape rectangle2 = new Rectangle(3, 5);

        System.out.println(sumAreas(circle1, circle2));
        System.out.println(sumAreas(rectangle1, rectangle2));
    }

    private static double sumAreas(Shape c1, Shape circle2) {
        return c1.getArea() + circle2.getArea();
    }
}
