package org.example;

public class Main {
    public static void main(String[] args) {

        Account account = new Account();

        account.setDate("10/01/2012");
        account.deposit(1000);

        account.setDate("13/01/2012");
        account.deposit(2000);

        account.setDate("14/01/2012");
        account.withdraw(500);

        account.printStatement();

    }
}