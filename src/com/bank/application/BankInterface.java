package com.bank.application;

import java.util.*;

// import javax.sql.rowset.spi.TransactionalWriter;
//
// import com.bank.util.TransactionValidator;

public class BankInterface {
    public static void main(String[] args) {

        BankTransaction bankTransaction = new BankTransaction();

        // BankDetailsFileReader bankDetailsReader = new
        // BankDetailsFileReader();
        // bankDetailsReader.read();
        Scanner in = new Scanner(System.in);
        boolean yesNo = true;
        while (yesNo) {
            System.out.println("\nEnter any of the below options:");
            System.out.println("1 --> Deposit");
            System.out.println("2 --> Withdraw");
            System.out.println("3 --> Statement");
            System.out.println("4 --> Balance");

            int userChoice = in.nextInt();

            // BankDetailsFileReader bankDetailsFileReader = new
            // BankDetailsFileReader();
            //
            // BankAccount bankAccount = new BankAccount();

            // TransactionList transactions = new TransactionList();
            // int total = transactions.calculateBalance();
            //
            // int balance = bankDetailsFileReader.read();
            // bankAccount.setBalance(balance);

            // System.out.println("afssads" +bankAccount.getBalance());

            // bankAccount.setBalance(balance);
            int amount;
            switch (userChoice) {
                case 1:
                    System.out.println("Enter amount to deposit:");
                    amount = in.nextInt();
                    bankTransaction.deposit(amount);
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw:");
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
            String yesNoChoice = in.next().toLowerCase();
            yesNo = yesNoChoice.charAt(0) == 'y' ? true : false;
            System.out.println();
        }

        if (!yesNo) {
            // System.out.println("yesno");
            bankTransaction.updateBankStatement();
        }

        in.close();

    }

}
