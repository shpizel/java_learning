package ru.java.course.first.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * На вход программе задается число. Программа должна определить является ли оно простым или нет.
 * Простое число - это такое число, которое делится только на 1 и на само себя.
 *
 * Пример простых числе: 1, 3,7, 17,19,23 и т.д.
 */
public class SimpleDigit {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int number = getNumberFromConsole();
        System.out.println(number + " " + (isSimpleDigit(number) ? "простое" : "НЕпростое") + " число");
    }

    public static int getNumberFromConsole() {
        int number;
        System.out.print("Введите число: ");

        while (true) {
            try {
                number = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.print("Вы ввели не число, введите число: ");
                scanner.nextLine();
            }
        }
        return number;
    }

    /**
     * Тупое решение - умного не знаю
     *
     * @param digit
     * @return boolean
     */
    public static boolean isSimpleDigit(int digit) {
        if (digit < 0) digit *= -1;

        for (int i = 1; i < digit; i++) {
            if (digit % i == 0) {
                if (i > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
