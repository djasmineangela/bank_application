package com.bank.application;

import java.util.*;

import javax.sql.rowset.spi.TransactionalWriter;

import com.bank.util.TransactionValidator;

public class BankInterface {
    public static void main(String[] args) {
        
//        while(true) {
            System.out.println("Enter any of the below options:");
            System.out.println("1 --> Deposit");
            System.out.println("2 --> Withdraw");
            System.out.println("3 --> Statement");
            System.out.println("4 --> Balance");
            
            Scanner in = new Scanner(System.in);
            int userChoice = in.nextInt();            
            
            BankDetailsFileReader bankDetailsFileReader = new BankDetailsFileReader();
         
            BankAccount bankAccount = new BankAccount();
            
//            TransactionList transactions = new TransactionList();
//            int total = transactions.calculateBalance();
//            
            int balance = bankDetailsFileReader.read();
            bankAccount.setBalance(balance);
            
            BankTransaction bankTransaction = new BankTransaction();
            System.out.println("afssads" +bankAccount.getBalance());
            
//            bankAccount.setBalance(balance);
            
            switch (userChoice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    int amount = in.nextInt();
                    
                    break;

                default:
                    break;
            }
        }

    
} 
