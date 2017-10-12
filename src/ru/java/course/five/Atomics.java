package ru.java.course.five;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomics {
    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(7);
        i.getAndAdd(1);
    }
}
