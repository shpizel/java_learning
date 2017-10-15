package ru.yandex.java.course.second.homework.Queue;

import ru.yandex.java.course.first.homework.MyList.MyListGeneric;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class QueueTTL extends MyListGeneric<QueueElement> {
    /** seconds */
    private int ttl;

    public QueueTTL(int ttl) {
        super();
        this.ttl = ttl;
    }

    public QueueTTL(int initialCapacity, int ttl) {
        super(initialCapacity);
        this.ttl = ttl;
    }


    public String get() {
        QueueElement result;

        while (true) {
            if (cursor <= 0) {
                throw new ArrayIndexOutOfBoundsException("Cursor cannot be smaller than 0");
            }

            result = (QueueElement) storage[cursor - 1];
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
}