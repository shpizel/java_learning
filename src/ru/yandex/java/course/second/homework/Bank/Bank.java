package ru.yandex.java.course.second.homework.Bank;

/*
 * 1.1 Написать программу, которая будет переводить деньги между счетами пользователей. Необходимо использовать объектно-ориентированной подход.
 * Каждый класс должен отвечать только за одну функцию. Не должно быть такого, что логика по перечислению средств находится в том же классе, который описывает счет клиента.
 * 1.2 Если перевести деньги со счета на счет не удалось - должен бросаться NotSufficientAmount exception.
 * 1.3 Появляется два типа счетов. Один позволяет овердрафт, другой нет. Величина овердрафта должна задаваться при создании аккаунта.
 */
public class Bank {
    public static void main(String[] args) throws NotSufficientAmount{
        Account from = new Account(100);
        Account to = new Account(0);

        try {
            AccountTransfer.transfer(from, to, 10);
        } catch (NotSufficientAmount e) {
            System.err.println(e.getMessage());
        } finally {
            if (from.getAmount() == 90 && to.getAmount() == 10) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }
        }

        try {
            AccountTransfer.transfer(from, to, 91);
        } catch (NotSufficientAmount e) {
            System.err.println(e.getMessage());
        } finally {
            if (from.getAmount() == 90) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }
        }

        from.setOverdraftEnabled(true);
        from.setOverdraftValue(10);
        try {
            AccountTransfer.transfer(from, to, 100);
        } catch (NotSufficientAmount e) {
            System.err.println(e.getMessage());
        } finally {
            if (from.getAmount() == -10 && to.getAmount() == 110) {
                System.out.println("OK");
            } else {
                System.out.println("FAIL");
            }
        }
    }
}
