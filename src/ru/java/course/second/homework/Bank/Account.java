package ru.java.course.second.homework.Bank;

/**
 * Счет клиента в копейках
 */
public class Account {

    private long amount;
    private boolean overdraftEnabled = false;
    private long overdraftValue;

    public Account(long amount) {
        setAmount(amount);
    }

    public Account(long amount, boolean overdraftEnabled, long overdraftValue) {
        setAmount(amount);
        setOverdraftEnabled(overdraftEnabled);
        setOverdraftValue(overdraftValue);

    }

    public long getOverdraftValue() {
        return overdraftValue;
    }

    public void setOverdraftValue(long overdraftValue) {
        this.overdraftValue = overdraftValue;
    }

    public boolean isOverdraftEnabled() {
        return overdraftEnabled;
    }

    public void setOverdraftEnabled(boolean overdraftEnabled) {
        this.overdraftEnabled = overdraftEnabled;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void incrementAmount(long amount) {
        this.amount += amount;
    }

    public void decrementAmount(long amount) {
        this.amount -= amount;
    }
}
