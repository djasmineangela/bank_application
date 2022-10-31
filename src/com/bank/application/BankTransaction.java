package com.bank.application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        }

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }

        // return total;

    }

    public void withdraw(int amount) {
        if (isDivisibleBy100(amount) & checkAmountLimit(amount)) {
            transactionList.add("-" + amount);
            int totalBalance = bankAccount.getBalance() - amount;
            bankAccount.setBalance(totalBalance);
            System.out.println("Total Balance: " + totalBalance);
        }

        for (String trans : transactionList.getTransactions()) {
            System.out.println(trans);
        }
    }

    public void getStatement() {
        // bankDetailsFileWriter = new BankDetailsFileWriter();
        // bankDetailsFileWriter.displayStatement();

        // for (String transaction : transactionList.getTransactions()) {
        //// bufferedWriter.write(transaction + "\n");
        // System.out.println(transaction);
        // }

        String fileName = "C:\\Users\\parnit\\Downloads\\bank_application-main\\bank_application-main\\src\\bankFiles\\bankStatement.txt";
//        String fileName = "D:\\workspace\\BankApplication\\src\\bankFiles\\bankStatement.txt";
        
        File myFile = new File(fileName); 

        FileWriter fileWriter;
        BufferedWriter bufferedWriter;

        try {

            if (myFile.exists()) {
                myFile.delete();
            }

            myFile.createNewFile();
            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);
           
            for (String transaction : transactionList.getTransactions()) {
                bufferedWriter.write("\n" + transaction);
                System.out.println(transaction);
            }

            
            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
