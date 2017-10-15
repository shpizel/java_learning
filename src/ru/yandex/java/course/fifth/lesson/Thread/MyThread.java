package ru.yandex.java.course.fifth.lesson.Thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
