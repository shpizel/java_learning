package ru.yandex.java.course.first.lesson;

import ru.yandex.java.course.first.homework.MyList;

import java.util.ArrayList;

public class HelloWorld {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);


//        while (true) {
//            try {
//                num = scanner.nextInt();
//                break;
//            } catch (java.util.InputMismatchException e) {
//                System.err.println("Не число!");
//                scanner.nextLine();
//                System.out.print("Введи число: ");
//
//            }
//        }
//        for (int i=0;i<4;i++) {
//            System.out.print("Введи число: ");
//            num = scanner.nextInt();
//
//            if (num % 2 == 0) {
//                System.out.println("Четное");
//            } else {
//                System.out.println("Нечетное!");
//            }
//        }

//        while (true) {
//            System.out.print("Введи число: ");
//            System.out.println(isChetnoe(scanner.nextInt()) ? "Четное" : "Нечетное");
//            System.out.print("Продолжать? (Y/N): ");
//            String reg = scanner.next();
//            if (reg.equals("N")) {
//                break;
//            }
//        }


        // test 1
        MyList list = new MyList(1);
        list.add(4);
        list.add(6);
        list.add(1, 1);
        list.add(7);
        if (list.toString().equals("[4,1,6,7]")) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }

        list = new MyList(1);
        list.add(1);
        list.add(2);
        list.add(4, 1);
        list.add(7);
        if (list.toString().equals("[1,4,2,7]")) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }

        list = new MyList(1);
        list.add(9);
        list.add(7);
        list.add(8, 1);
        list.add(6);
        list.add(4);
        list.add(5, 4);
        list.add(2);
        list.add(3, 6);
        list.add(1);

        if (list.toString().equals("[9,8,7,6,5,4,3,2,1]")) {
            System.out.println("OK");
        } else {
            System.out.println("FAIL");
        }
    }

    public static int max(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;

        for (Integer i: list) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    private static boolean isChetnoe(int num) {
        if (num % 2 == 0) {
            return true;
        }

        return false;
    }
}