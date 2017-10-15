package ru.yandex.java.course.fifth.lesson;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomics {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(7);
        i.getAndAdd(1);
        System.out.println(i.get());

    }
}
