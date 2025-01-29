package org.example;

public class Transaction {
    private final String date;
    private final int amount;
    private final int balanceAfterTransaction;

    public Transaction(String date, int amount, int balanceAfterTransaction) {
        this.date = date;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    public String getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }
}
