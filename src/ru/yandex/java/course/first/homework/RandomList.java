package ru.yandex.java.course.first.homework;

import java.util.Random;

/**
 * Программа должна создать массив из 12 случайных целых чисел из отрезка [-10;10] таким образом,
 * чтобы отрицательных и положительных элементов там было поровну и не было нулей.
 *
 * Вывести полученный массив на экран.
 */
public class RandomList {

    public static final int ARRAY_SIZE = 12;
    public static final int MIN = -10;
    public static final int MAX = 10;

    public static Random random = new Random();

    public static void main(String[] args) {
        int[] result = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            result[i] = getRandom(MIN, MAX, true);
        }

        int positivesCount, negativesCount, index;
        while ((positivesCount = count(result, true)) != (negativesCount = count(result, false))) {
            if (positivesCount > negativesCount) {
                // надо выбирать индекс где позитивы и менять на негативы
                index = getFirstIndex(result, true);
                result[index] = getRandom(MIN, MAX, true, false);
            } else {
                // надо выбирать индекс где негативы и менять на позитивы
                index = getFirstIndex(result, false);
                result[index] = getRandom(MIN, MAX, true, true);
            }
        }

        String[] elements = new String[result.length];
        for (int i = 0; i < result.length; i++) {
            elements[i] = String.valueOf(result[i]);
        }
        System.out.println("[" + String.join(",", elements) + "]");

    }

    protected static int getFirstIndex(int[] array, boolean positive) {
        for (int i = 0; i < array.length; i++) {
            if ((positive && array[i] > 0) || (!positive && array[i] < 0)) {
                return i;
            }
        }

        throw new IllegalArgumentException();
    }

    protected static int getRandom(int min, int max, boolean notZero) {
        while (notZero) {
            int result = getRandom(min, max);
            if (result != 0) {
                return result;
            }
        }

        return getRandom(min, max);
    }

    /**
     *
     * @param min
     * @param max
     * @param notZero
     * @param positive
     * @return int
     */
    protected static int getRandom(int min, int max, boolean notZero, boolean positive) {
        int random;
        while (true) {
            random = getRandom(min, max, notZero);
            if ((positive && random > 0) || (!positive && random < 0)) {
                return random;
            }
        }
    }

    /**
     * https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
     *
     * @param min
     * @param max
     * @return int
     */
    protected static int getRandom(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    /**
     * Считает количество положительных/отрицательных чисел в массиве
     *
     * @param array
     * @param positive
     * @return int
     */
    protected static int count(int[] array, boolean positive) {
        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if ((positive && array[i] > 0) || (!positive && array[i] < 0)) {
                count++;
            }
        }

        return count;
    }
}
