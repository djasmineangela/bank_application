package com.bank.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.bank.util.TransactionValidator;

public class BankTransaction extends TransactionValidator implements Validator {
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

    public void deposit(int amount) {
        if (isDivisibleBy100(amount) & checkAmountLimit(amount)) {
            transactionList.add("+" + amount);
            int totalBalance = bankAccount.getBalance() + amount; // current
                                                                  // balance
            // +
            bankAccount.setBalance(totalBalance); // deposited amount
            System.out.println("Total Balance: " + totalBalance);
            System.out.println("Transaction successful!");
        } else {
            System.out.println("Transaction failure!");
        }

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }

        // return total;

    }

    public void withdraw(int amount) {
        if (!isAmountLessThanBalance(bankAccount, amount)) {
            System.out.println("Insufficient balance in your account");
        } else {
            if (isDivisibleBy100(amount) & checkAmountLimit(amount)) {
                transactionList.add("-" + amount);
                int totalBalance = bankAccount.getBalance() - amount;
                bankAccount.setBalance(totalBalance);
                System.out.println("Total Balance: " + totalBalance);
                System.out.println("Transaction successful!");
            }
        }

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }
    }

    public void getStatement() {
        for (String transaction : transactionList.getTransactions()) {
            System.out.println(transaction);
        }
    }

    public void updateBankStatement() {
        // bankDetailsFileWriter = new BankDetailsFileWriter();
        // bankDetailsFileWriter.displayStatement();

        // for (String transaction : transactionList.getTransactions()) {
        //// bufferedWriter.write(transaction + "\n");
        // System.out.println(transaction);
        // }

        String fileName = "C:\\Users\\parnit\\Downloads\\bank_application-main\\bank_application-main\\src\\bankFiles\\bankStatement.txt";
        // String fileName = "D:\\workspace\\BankApplication\\src\\bankFiles\\bankStatement.txt";

        File bankStatement = new File(fileName);

        FileWriter fileWriter;
        PrintWriter out;

        try {

            if (bankStatement.exists()) {
                System.out.println("exists");
                bankStatement.delete();
            }

            bankStatement.createNewFile();
            fileWriter = new FileWriter(fileName, false);
            // bufferedWriter = new BufferedWriter(fileWriter);
            out = new PrintWriter(fileWriter);
            for (String transaction : transactionList.getTransactions()) {
                out.println(transaction);
                System.out.println("fasdfasdfad" + transaction);
            }
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage()); 
        }

    }

    public void balance() {
        System.out.println("Your balance is: " + bankAccount.getBalance());
    }

}
