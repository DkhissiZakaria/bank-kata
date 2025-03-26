package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
        try {
            LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            this.currentDate = date;
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Use dd/MM/yyyy.");
        }
    }


    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(currentDate, amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (balance - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal");
        }
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
            System.out.printf("%-10s || %-6d || %-6d%n", date, amount, balanceAtThatTime);
        }
    }
}
