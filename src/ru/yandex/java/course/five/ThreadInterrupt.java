package ru.yandex.java.course.five;

public class ThreadInterrupt {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                ++count;
            }

            System.out.println(count);
        });

        thread.start();
        Thread.currentThread().sleep(10);
        thread.interrupt();
    }
}
