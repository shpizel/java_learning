package ru.yandex.java.course.second.homework.Queue;

import ru.yandex.java.course.first.homework.MyList.MyListGeneric;

/**
 * 2.1 Реализовать очередь FIFO (первым зашел - первым вышел) на основе массива String[],
 * у которой есть два метода: положить объект в очередь и получить объект из очереди(при получении объект удаляется из очереди)
 */
public class Queue extends MyListGeneric<String> {
    public String get() {
        if (cursor <= 0) {
            throw new ArrayIndexOutOfBoundsException("Cursor cannot be smaller than 0");
        }

        String result = (String) storage[cursor - 1];
        storage[cursor - 1] = null;
        cursor--;

        return result;
    }
}