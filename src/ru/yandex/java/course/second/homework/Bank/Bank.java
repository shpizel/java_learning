package ru.yandex.java.course.second.homework.Bank;

public class Bank {
    public static void main(String[] args) throws NotSufficientAmount{
        Account from = new Account(100);
        Account to = new Account(0);

        AccountTransfer.transfer(from, to, 10);

        if (from.getAmount() == 90 && to.getAmount() == 10) {
            System.out.println("OK");
        }

        from = new Account(100, true, 10);
        AccountTransfer.transfer(from, to, 111);
    }

}
