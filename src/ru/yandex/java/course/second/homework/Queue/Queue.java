package ru.yandex.java.course.second.homework.Queue;

public class Queue {
    protected static final int INCREMENT = 2;
    protected static final int DEFAULT_CAPACITY = 2;

    protected String[] storage;

    /**
     * Размер массива
     */
    protected int capacity;

    /**
     * Указатель на следующий элемент массива
     */
    protected int cursor = 0;

    public Queue() {
        capacity = DEFAULT_CAPACITY;
        storage = new String[capacity];

    }

    public Queue(int initialCapacity) {
        capacity = initialCapacity;
        storage = new String[capacity];
    }

    /**
     * Добавление в конец
     *
     * | 0 | 1 | 2 |   |
     *               ^
     *               |
     *               3
     *
     * @param element
     */
    public void put(String element) {
        // Если следующий элемент ставить некуда - расширяем массив
        if (cursor < capacity) {
            storage[cursor++] = element;
        } else {
            increaseCapacity();
            put(element);
        }
    }

    public String get() {
        if (cursor <= 0) {
            throw new ArrayIndexOutOfBoundsException("Cursor cannot be smaller than 0");
        }

        String result = storage[cursor - 1];
        storage[cursor - 1] = null;
        cursor--;

        return result;
    }

    /**
     * Size getter
     *
     * @return int
     */
    public int size() {
        return cursor ;
    }

    protected void increaseCapacity() {
        String newStorage[] = new String[capacity * INCREMENT];
        System.arraycopy(storage, 0, newStorage, 0, capacity);
        capacity *= INCREMENT;
        storage = null;
        storage = newStorage;
    }

    @Override
    public String toString() {
        return "[" + String.join(",", storage) + "]";
    }
}