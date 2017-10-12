package ru.java.course.first.homework;

/**
 * Вывести на консоль первые n чисел последовательности Фибоначчи, где n - задается через консоль.
 * Последовательность Фибоначчи - последовательность в которой каждый следующий элемент равен сумме двух предыдущих.
 * Начинается с 0 и 1.
 *
 * Пример первых чисел в последовательности Фибоначчи 0,1,1,2,3,5,8,13,21 и т.д.
 */
public class Fibonacci extends SimpleDigit {
    public static void main(String[] args) {
        int number = getNumberFromConsole();
        for (int i = 0; i <= number; i++) {
            System.out.println(fibonacci(i));
        }
    }

    /**
     * Фибоначчи
     *
     * @param number
     * @return
     */
    private static int fibonacci(int number) {
        // первый элемент всегда 0, а второй и третий единица
        if (number == 0) {
            return 0;
        } else if (number <= 2) {
            return 1;
        }

        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
