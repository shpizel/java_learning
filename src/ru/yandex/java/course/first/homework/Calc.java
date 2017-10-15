package ru.yandex.java.course.first.homework;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calc {
    enum Sign {
        PLUS {
            @Override
            double doOperation(int a, int b) {
                return a + b;
            }

            @Override
            String getSymbol() {
                return "+";
            }
        },
        MINUS {
            @Override
            double doOperation(int a, int b) {
                return a - b;
            }

            @Override
            String getSymbol() {
                return "-";
            }
        },
        MULTIPLY {
            @Override
            double doOperation(int a, int b) {
                return a * b;
            }

            @Override
            String getSymbol() {
                return "*";
            }
        },
        DIVIDE {
            @Override
            double doOperation(int a, int b) {
                return (double) a / (double) b;
            }

            @Override
            String getSymbol() {
                return "*";
            }
        };

        abstract double doOperation(int a, int b);
        abstract String getSymbol();
    }

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Sign sign = getSignFromConsole();

        int first = 0, second = 0;
        first = getNumberFromConsole();
        second = getNumberFromConsole();

        System.out.println("Результат:");
        System.out.println(first + " " + sign.getSymbol() + " " + second + " = " + sign.doOperation(first, second));
    }

    private static Sign getSignFromConsole() {
        while (true) {
            try {
                System.out.print("Введите знак: ");
                String next = scanner.next();
                switch (next) {
                    case "*":
                        return Sign.MULTIPLY;
                    case "/":
                        return Sign.DIVIDE;
                    case "+":
                        return Sign.PLUS;
                    case "-":
                        return Sign.MINUS;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Неверный ввод. Вы можете ввести + - * /");
                scanner.nextLine();
            }
        }
    }

    protected static int getNumberFromConsole() {
        int number;
        while (true) {
            System.out.print("Введите число: ");
            try {
                number = scanner.nextInt();
                System.out.println("Введено число: " + number);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Неверный ввод. Введите число!");
                scanner.nextLine();
            }
        }

        return number;
    }
}
