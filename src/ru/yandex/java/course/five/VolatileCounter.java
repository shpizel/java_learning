package ru.yandex.java.course.five;

public class VolatileCounter extends Thread {
    volatile boolean keepRunning = true;

    public static void main(String[] args) throws InterruptedException {
        VolatileCounter volatileCounter = new VolatileCounter();
        volatileCounter.start();

        Thread.currentThread().sleep(1000L);
        volatileCounter.keepRunning = false;
        System.out.println("Set to false..");
    }

    @Override
    public void run() {
        int count = 0;
        while (keepRunning) {
            ++count;
        }

        System.out.println(count);
    }
}
