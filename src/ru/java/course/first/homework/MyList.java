package ru.java.course.first.homework;

public class MyList {

    private static final int INCREMENT = 2;
    private static final int DEFAULT_CAPACITY = 2;

    private int storage[];

    /**
     * Размер массива
     */
    private int capacity;

    /**
     * Указатель на следующий элемент массива
     */
    private int cursor = 0;

    public MyList() {
        capacity = DEFAULT_CAPACITY;
        storage = new int[capacity];

    }

    public MyList(int initialCapacity) {
        capacity = initialCapacity;
        storage = new int[capacity];
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
    public void add(int element) {
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
    public void add(int element, int beforeIndex) {
        //Если индекс меньше нуля или больше размера массива то ошибка
        if (beforeIndex < 0 || beforeIndex >= cursor) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // Если +1 элемент вылезет за пределы массива то массив надо расширить
        if (cursor + 1 >= capacity) {
            this.increaseCapacity();
        }

        int[] newStorage = new int[capacity];
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
    public int get(int index) {
        return storage[index];
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
        int newStorage[] = new int[capacity * INCREMENT];
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
