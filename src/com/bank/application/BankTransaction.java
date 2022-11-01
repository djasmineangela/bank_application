package com.bank.application;

import java.util.List;

import com.bank.util.TransactionValidator;

public class BankTransaction extends TransactionValidator implements Validator {
    BankAccount bankAccount;
    BankDetailsFileReader bankDetailsFileReader;
    TransactionList transactionList;

    public BankTransaction() {
        bankDetailsFileReader = new BankDetailsFileReader();
        bankAccount = new BankAccount();
        List<String> transactions = bankDetailsFileReader.read();
        // bankAccount.setBalance(balance);
        transactionList = new TransactionList();
        transactionList.setTransactions(transactions);
        int balance = transactionList.calculateBalance();
        bankAccount.setBalance(balance);
    }

    public void deposit(int amount) {
        if (isDivisibleBy100(amount) & checkAmountLimit(amount)) {
            transactionList.add("+" + amount);
            int totalBalance = bankAccount.getBalance() + amount; // current
                                                                  // balance
            // +
            bankAccount.setBalance(totalBalance); // deposited amount
            System.out.println("Total Balance: " + totalBalance);
        } // else need

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }

        // return total;

    }

    public void withdraw(int amount) {
        // if (isAmountLessThanBalance(bankAccount, amount)) {
        // System.out.println("goodss");
        // } else {
        // System.out.println("not goods");
        // }
        if (isDivisibleBy100(amount) & checkAmountLimit(amount) & isAmountLessThanBalance(bankAccount, amount)) {
            transactionList.add("-" + amount);
            int totalBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(totalBalance);
            System.out.println("Total Balance: " + totalBalance);
        }

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }
    }
    
    public void statement() {
        
    }
    
    public void balance() {
        System.out.println("Your balance is: "+ bankAccount.getBalance());
    }
}
