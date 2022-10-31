package com.bank.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankDetailsFileReader extends TransactionList {
    File bankStatement = new File("D:\\workspace\\BankApplication\\src\\bankFiles\\bankStatement.txt");
    FileReader fileReader = null;
    BufferedReader reader = null;

    public List<String> read() {
        List<String> transactions = new ArrayList<>();
        // int totalBalance =0;
        try {

            fileReader = new FileReader(bankStatement);
            reader = new BufferedReader(fileReader);

            if (bankStatement.exists()) {
                String line = null;// +1000
                while ((line = reader.readLine()) != null) { // read
                    System.out.println(line);
                    transactions.add(line); // storing
                }

                // setTransactions(transactions);
                // parseOperator();

            } else {
                bankStatement.createNewFile();
                System.out.println("File: " + bankStatement.getCanonicalPath() + " successfully created");
            }

        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("Error: " + e.getMessage());
        }

        return transactions;
    }

}
