package ru.yandex.java.course.second.homework.Bank;

/**
 * Перевод денег со счета на счет
 */
public class AccountTransfer {

    public static void transfer(Account from, Account to, long amount) throws NotSufficientAmount {
        long fromAmount = from.getAmount();

        if (!from.isOverdraftEnabled()  && fromAmount < amount) {
            throw new NotSufficientAmount();
        } else if (from.isOverdraftEnabled() && fromAmount + from.getOverdraftValue() < amount) {
            throw new NotSufficientAmount();
        }

        from.decrementAmount(amount);
        to.incrementAmount(amount);
    }
}
