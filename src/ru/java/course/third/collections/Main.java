package ru.java.course.third.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Student alex = new Student("Alex", 18, 5.0);
        Student kate = new Student("Kate", 17, 4.5);
        Student john = new Student("John", 19, 3.7);

        list.add(alex);
        list.add(kate);
        list.add(john);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, (o1, o2) -> Double.compare(o1.getAverageScore(), o2.getAverageScore()));
        Collections.sort(list, Comparator.comparing(Student::getAverageScore));
        System.out.println(list);
    }
}
