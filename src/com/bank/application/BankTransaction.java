package com.bank.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bank.util.TransactionValidator;

public class BankTransaction extends TransactionValidator implements Transaction {
    BankAccount bankAccount;
    BankDetailsFileReader bankDetailsFileReader;
    BankDetailsFileWriter bankDetailsFileWriter;
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

    @Override
    public void deposit(int amount) {

        if(checkDivisibilityandLimit(amount)) {
            transactionList.add("+" + amount); //$NON-NLS-1$
            int totalBalance = bankAccount.getBalance() + amount; // current
            bankAccount.setBalance(totalBalance); // deposited amount
            System.out.println("Total Balance: " + totalBalance);
            System.out.println("Transaction successful!");
        }
    }

    @Override
    public void withdraw(int amount) {
        if (!isAmountLessThanBalance(bankAccount, amount)) {
            System.out.println("Insufficient balance in your account");
        }

        if (checkDivisibilityandLimit(amount)) {
            transactionList.add("-" + amount); //$NON-NLS-1$
            int totalBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(totalBalance);
            System.out.println("Total Balance: " + totalBalance);
            System.out.println("Transaction successful!");
        }
    }

    @Override
    public void getStatement() {
        for (String transaction : transactionList.getTransactions()) {
            System.out.println(transaction);
        }
    }

    public void closeTransaction() {
        BankDetailsFileWriter.updateBankStatement(transactionList.getTransactions());

    }

    public void balance() {
        System.out.println("Your balance is: " + bankAccount.getBalance()); //$NON-NLS-1$
    }
    
    private boolean checkDivisibilityandLimit(int amount) {
        boolean check = true;
        if (!isDivisibleBy100(amount)) {
            System.out.println("Amount should be divisible by 100");
            check = false;
        }
        if (!checkAmountLimit(amount)) {
            System.out.println("Amount should not be greater than 10,000");
            check = false;
        }

        return check;
    }

}
