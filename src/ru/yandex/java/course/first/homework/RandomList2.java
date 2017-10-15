package ru.yandex.java.course.first.homework;

/**
 * Создать два массива размером 20 элементов. Каждый из них заполнить случайными числами от 0 до 100.
 * На консоль вывести только те числа, которые содержатся в каждом массиве(их пересечение).
 */
public class RandomList2 extends RandomList {

    private static final int ARRAY_SIZE = 20;
    private static final int MIN = 0;
    private static final int MAX = 100;

    public static void main(String[] args) {
        int[] first = new int[ARRAY_SIZE];
        int[] second = new int[ARRAY_SIZE];


        for (int i = 0; i < ARRAY_SIZE; i++) {
            first[i] = getRandom(MIN, MAX);
            second[i] = getRandom(MIN, MAX);
        }

        // найдем пересечения
        for (int aFirst : first) {
            if (inArray(second, aFirst)) {
                System.out.println(aFirst);
            }
        }
    }

    private static boolean inArray(int[] array, int search) {
        for (int anArray : array) {
            if (anArray == search) {
                return true;
            }
        }

        return false;
    }
}
