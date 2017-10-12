package ru.java.course.five;

public class AccountService {

    public void transfer(Account from, Account to, long amount) {
        Object monitor1 = null;
        Object monitor2 = null;

        if (from.getId() < to.getId()) {
            monitor1 = from;
            monitor2 = to;
        } else {
            monitor1 = to;
            monitor2 = from;
        }

        synchronized (monitor1) {
            //System.out.println(Thread.currentThread().getName() + " sync on " + monitor1);
            synchronized (monitor2) {
                //System.out.println(Thread.currentThread().getName() + " sync on " + monitor2);
                if (from.getAmount() >= amount) {
                    from.setAmount(from.getAmount() - amount);
                    to.setAmount(to.getAmount() + amount);
                    return;
                }
            }
        }

        throw new IllegalStateException("Account " + from + " doesn't have enough money");
    }
}
