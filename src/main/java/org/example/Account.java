package org.example;

import java.util.ArrayList;
import java.util.List;

public class Account implements AccountService {

    private int balance = 0;
    private final List<Transaction> transactions = new ArrayList<>();
    private String currentDate = "01/01/2001"; // Default value

    /**
     * Helper method: sets the "current" date (not enforced by the interface,
     * but useful for reproducing the scenario in tests).
     */
    public void setDate(String date) {
        this.currentDate = date;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(currentDate, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        balance -= amount;
        transactions.add(new Transaction(currentDate, -amount, balance));
    }

    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            String date = t.getDate();
            int amount = t.getAmount();
            int balanceAtThatTime = t.getBalanceAfterTransaction();
            System.out.println(date + " || " + amount + "  " + " || " + balanceAtThatTime);
        }
    }
}
