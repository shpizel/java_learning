package ru.java.course.five.Thread;

public class MyThread extends Thread {
    @Override
    public void run() {
        while(true) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
