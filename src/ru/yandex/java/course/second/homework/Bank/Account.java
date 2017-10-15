package ru.yandex.java.course.second.homework.Bank;

/**
 * 1.1 Написать программу, которая будет переводить деньги между счетами пользователей. Необходимо использовать объектно-ориентированной подход.
 * Каждый класс должен отвечать только за одну функцию. Не должно быть такого, что логика по перечислению средств находится в том же классе, который описывает счет клиента.
 * 1.2 Если перевести деньги со счета на счет не удалось - должен бросаться NotSufficientAmount exception.
 * 1.3 Появляется два типа счетов. Один позволяет овердрафт, другой нет. Величина овердрафта должна задаваться при создании аккаунта.

 * Счет клиента в копейках
 */
public class Account {

    private long amount;
    private boolean overdraftEnabled = false;
    private long overdraftValue;

    public Account(long amount) {
        setAmount(amount);
    }

    public Account(long amount, long overdraftValue) {
        setAmount(amount);
        setOverdraftEnabled(true);
        setOverdraftValue(overdraftValue);
    }

    public long getOverdraftValue() {
        return overdraftValue;
    }

    public Account setOverdraftValue(long overdraftValue) {
        this.overdraftValue = overdraftValue;
        return this;
    }

    public boolean isOverdraftEnabled() {
        return overdraftEnabled;
    }

    public Account setOverdraftEnabled(boolean overdraftEnabled) {
        this.overdraftEnabled = overdraftEnabled;
        return this;
    }

    public long getAmount() {
        return amount;
    }

    public Account setAmount(long amount) {
        this.amount = amount;
        return this;
    }

    public Account incrementAmount(long amount) {
        this.amount += amount;
        return this;
    }

    public Account decrementAmount(long amount) {
        this.amount -= amount;
        return this;
    }
}
