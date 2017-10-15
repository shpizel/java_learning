package ru.yandex.java.course.second.homework.Queue;

public class QueueTest {
    public static void main(String[] args) throws InterruptedException {
//        Queue q = new Queue(10);
//        q.put("a");
//        q.put("b");
//        q.put("c");
//        if (q.get().equals("c")) {
//            System.out.println("OK");
//        }
//        q.get();
//        q.get();
//        q.get();

//        System.out.println(LocalDateTime.now().toString());
        QueueTTL q = new QueueTTL(10, 3);
        q.put("a");
        q.put("b");
        Thread.sleep(3000);
        q.put("c");
        Thread.sleep(1000);

        System.out.println(q.get());
        System.out.println(q.get());
    }
}
