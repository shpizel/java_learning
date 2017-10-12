package ru.java.course.five;

public class Account {
    public int getId() {
        return id;
    }

    private int id;
    private volatile long amount;
    private String name;

    public Account(int id, long amount, String name) {
        this.id = id;
        this.amount = amount;
        this.name = name;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                '}';
    }
}
