package org.example.account;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
