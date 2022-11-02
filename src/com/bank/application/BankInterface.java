package com.bank.application;

import java.util.*;

// import javax.sql.rowset.spi.TransactionalWriter;
//
// import com.bank.util.TransactionValidator;

public class BankInterface {
    public static void main(String[] args) {

        BankTransaction bankTransaction = new BankTransaction();

        Scanner in = new Scanner(System.in);
        boolean continueTransaction = true;
        while (continueTransaction) {
            System.out.println("1 --> Deposit");
            System.out.println("2 --> Withdraw");
            System.out.println("3 --> Statement");
            System.out.println("4 --> Balance");
            System.out.print("Enter any of the above options: ");
            int userChoice = in.nextInt();

            int amount;
            switch (userChoice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    amount = in.nextInt();
                    bankTransaction.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    amount = in.nextInt();
                    bankTransaction.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Bank Statement:");
                    bankTransaction.getStatement();
                    break;
                case 4:
                    bankTransaction.balance();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

            System.out.print("Do you want to continue? (y/n) ");
            String continueTransactionChoice = in.next().toLowerCase();
            continueTransaction = continueTransactionChoice.charAt(0) == 'y' ? true : false;
            System.out.println();
        }

        if (!continueTransaction) {
            // System.out.println("yesno");
            bankTransaction.closeTransaction();
        }

        in.close();

    }

}
