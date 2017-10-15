package ru.yandex.java.course.third;

public enum Course {
    MATH {
        @Override
        void printName() {
            System.out.println(name());
        }
    },
    PHYSICS(3) {
        @Override
        void printName() {
            System.out.println(name());
        }
    };

    int semestr;

    Course() {

    }

    Course(int semestr) {
        this.semestr = semestr;
    }

    abstract void printName();
}
