package ru.yandex.java.course.second.homework.Bank;

/**
 * 1.1 Написать программу, которая будет переводить деньги между счетами пользователей. Необходимо использовать объектно-ориентированной подход.
 * Каждый класс должен отвечать только за одну функцию. Не должно быть такого, что логика по перечислению средств находится в том же классе, который описывает счет клиента.
 * 1.2 Если перевести деньги со счета на счет не удалось - должен бросаться NotSufficientAmount exception.
 * 1.3 Появляется два типа счетов. Один позволяет овердрафт, другой нет. Величина овердрафта должна задаваться при создании аккаунта.
 *
 * Перевод денег со счета на счет с учетом overdraft
 */
public class AccountTransfer {

    /**
     * Transfers amount from 'from' to 'to' accounts
     *
     * @param from
     * @param to
     * @param amount
     * @throws NotSufficientAmount
     */
    public static void transfer(Account from, Account to, long amount) throws NotSufficientAmount {
        long fromAmount = from.getAmount();

        // Если overdraft выключен то мы не можем перевести больше чем есть на счету
        // поэтому если текущий счет меньше запрашиваемого перевода - бросаем исключение
        if (!from.isOverdraftEnabled() && fromAmount < amount) {
            throw new NotSufficientAmount("Overdraft disabled. Try to transfer " + amount + " from " + fromAmount);
        }
        // Если overdraft включен то у нас есть запас на overdraft, но если и его не хватает то бросаем исключение
        else if (from.isOverdraftEnabled() && ( (fromAmount + from.getOverdraftValue() ) < amount)) {
            throw new NotSufficientAmount(
                "Overdraft enabled. Try to transfer " + amount + " from " + fromAmount + ", overdraft is " + from.getOverdraftValue()
            );
        }

        //synchronized (AccountTransfer.class) {
        from.decrementAmount(amount);
        to.incrementAmount(amount);
        //}
    }
}
