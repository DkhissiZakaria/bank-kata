package org.example;

import org.example.account.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AccountAcceptanceTest {

    @Test
    public void should_print_statement_in_reverse_chronological_order() {
        Account account = new Account();

        account.setDate("10/01/2012");
        account.deposit(1000);

        account.setDate("13/01/2012");
        account.deposit(2000);

        account.setDate("14/01/2012");
        account.withdraw(500);

        ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(consoleOutput));

        account.printStatement();

        System.setOut(originalOut);
        String actualOutput = consoleOutput.toString();

        Assertions.assertTrue(actualOutput.contains("14/01/2012 || -500   || 2500"),
                "Missing the transaction from 14/01/2012");
        Assertions.assertTrue(actualOutput.contains("13/01/2012 || 2000   || 3000"),
                "Missing the transaction from 13/01/2012");
        Assertions.assertTrue(actualOutput.contains("10/01/2012 || 1000   || 1000"),
                "Missing the transaction from 10/01/2012");
    }
}
