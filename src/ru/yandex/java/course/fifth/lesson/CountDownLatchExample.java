package ru.yandex.java.course.fifth.lesson;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch cl = new CountDownLatch(3);

        // thread(cl).start()
        // thread(cl).start()
        // thread(cl).start()

//        cl.await(); // выполнится только когда треды вызовут countdown 3 раза
    }
}
