package ru.yandex.java.course.first.homework.MyList;

import java.util.ArrayList;

public class  MyListGeneric <T> {

    protected static final int INCREMENT = 2;
    protected static final int DEFAULT_CAPACITY = 2;

    protected Object[] storage;

    /**
     * Размер массива
     */
    protected int capacity;

    /**
     * Указатель на следующий элемент массива
     */
    protected int cursor = 0;

    public MyListGeneric() {
        capacity = DEFAULT_CAPACITY;
        storage = new Object[capacity];

    }

    public MyListGeneric(int initialCapacity) {
        capacity = initialCapacity;
        storage = new Object[capacity];
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
    public void add(T element) {
        // Если следующий элемент ставить некуда - расширяем массив
        if (cursor < capacity) {
            storage[cursor++] = element;
        } else {
            increaseCapacity();
            add(element);
        }
    }

    /**
     * Добавление перед другим элементом
     *
     *   0   1   2   3
     * | 1 | 2 | 3 | 4 |
     *    ^
     *    |
     *    0 => new[0] = 0 + arraycopy(old, 0, new, 1, size)
     *
     *   0   1   2   3
     * | 1 | 2 | 4 | 5 |
     *        ^
     *        |
     *        3 => arraycopy(old, 0, new, 0, 1) + new[1] = 3 + arraycopy(old, 1, old, 2, 3)
     *
     * @param element
     */
    public void add(T element, int beforeIndex) {
        //Если индекс меньше нуля или больше размера массива то ошибка
        if (beforeIndex < 0 || beforeIndex >= cursor) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // Если +1 элемент вылезет за пределы массива то массив надо расширить
        if (cursor + 1 >= capacity) {
            this.increaseCapacity();
        }

        Object[] newStorage = new Object[capacity];
        if (beforeIndex == 0) {
            newStorage[0] = element;
            // копируем массив с начала до конца, но в новый массив вставляем с первого элемента, т.к. нулевой занят
            System.arraycopy(storage, beforeIndex, newStorage, 1, cursor - beforeIndex);
        } else {
            System.arraycopy(storage, 0, newStorage, 0, beforeIndex);
            newStorage[beforeIndex] = element;
            System.arraycopy(storage, beforeIndex, newStorage, beforeIndex+1, cursor - beforeIndex);
        }

        storage = null;
        storage = newStorage;
        cursor++;
    }

    /**
     * Getter by id
     *
     * @param index
     * @return int
     */
    public T get(int index) {
        return (T) storage[index];
    }

    /**
     * Size getter
     *
     * @return int
     */
    public int size() {
        return cursor ;
    }

    private void increaseCapacity() {
        Object[] newStorage = new Object[capacity * INCREMENT];
        System.arraycopy(storage, 0, newStorage, 0, capacity);
        capacity *= INCREMENT;
        storage = null;
        storage = newStorage;
    }

    @Override
    public String toString() {
        String[] elements = new String[size()];
        for (int i = 0; i < size(); i++) {
            elements[i] = String.valueOf(storage[i]);
        }
        return "[" + String.join(",", elements) + "]";
    }
}
