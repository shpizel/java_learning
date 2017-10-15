package ru.yandex.java.course.fifth.lesson;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorPresentation {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.currentThread().sleep(100L);
                System.out.println("End " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdownNow();

        Executors.newCachedThreadPool(); // создает кешированные потоки, если он отработал то минуту он может быть переиспользован
        ScheduledExecutorService x = Executors.newScheduledThreadPool(5); // типа крона
//        x.scheduleAtFixedRate();

    }
}
