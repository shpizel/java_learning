package ru.yandex.java.course.second.homework.Queue;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class QueueTTL extends Queue {

    protected QueueElement[] storage;

    /** seconds */
    private int ttl;

    public QueueTTL(int capacity, int ttl) {
        super(capacity);
        this.storage = new QueueElement[capacity];
        this.ttl = ttl;
    }

    public void put(String element) {
        // Если следующий элемент ставить некуда - расширяем массив
        if (cursor < capacity) {
            storage[cursor++] = new QueueElement(element, LocalDateTime.now());
        } else {
            increaseCapacity();
            put(element);
        }
    }

    public String get() {
        QueueElement result;

        while (true) {
            if (cursor <= 0) {
                throw new ArrayIndexOutOfBoundsException("Cursor cannot be smaller than 0");
            }

            result = storage[cursor - 1];
            storage[cursor - 1] = null;
            cursor--;

            if (result.getCreated().plus(ttl, ChronoUnit.SECONDS).isBefore(LocalDateTime.now())) {
                continue;
            } else {
                break;
            }
        }

        return result.getValue();
    }

    protected void increaseCapacity() {
        QueueElement newStorage[] = new QueueElement[capacity * INCREMENT];
        System.arraycopy(storage, 0, newStorage, 0, capacity);
        capacity *= INCREMENT;
        storage = null;
        storage = newStorage;
    }
}