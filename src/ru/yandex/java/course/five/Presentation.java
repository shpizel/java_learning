package ru.yandex.java.course.five;

public class Presentation {
    public static void main(String[] args) throws InterruptedException {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        MyThread thread = new MyThread();
//        thread.start();
//        thread.join();

//        Thread thread = new Thread(() -> {
//            try {
//                System.out.println("Sleeping..");
//                Thread.currentThread().sleep(1_000);
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        //thread.setDaemon(true);
//        thread.start();
//        //thread.join();
//
//        System.out.println(Thread.currentThread().getName());

        AccountService accountService = new AccountService();
        Account john = new Account(0, 1_000_000, "John");
        Account kate = new Account(1, 0, "Kate");

        BankThread bankThread1 = new BankThread(john, kate, accountService);
        BankThread bankThread2 = new BankThread(kate, john, accountService);

        bankThread1.start();
        bankThread2.start();

        bankThread1.join();
        bankThread2.join();

        System.out.println(john);
        System.out.println(kate);
    }

    private static class BankThread extends Thread {
        private Account from;
        private Account to;
        private AccountService accountService;

        public BankThread(Account from, Account to, AccountService accountService) {
            this.from = from;
            this.to = to;
            this.accountService = accountService;
        }

        @Override
        public void run() {
            for (int i = 0; i < 500_000; i++) {
                accountService.transfer(from, to, 1);
            }
        }
    }
}
