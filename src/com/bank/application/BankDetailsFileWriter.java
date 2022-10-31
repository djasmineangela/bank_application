package com.bank.application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class BankDetailsFileWriter {
    
    TransactionList list;

    public void displayStatement() {
        
       list = new TransactionList();

        try {
//            FileWriter fileWriter = new FileWriter("C:\\Users\\parnit\\Downloads\\bank_application-main\\bank_application-main\\src\\bankFiles\\bankStatement.txt", true);
            
            FileWriter fileWriter = new FileWriter("C:\\Users\\parnit\\Documents\\trial.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String transaction : list.getTransactions()) {
                bufferedWriter.write(transaction);
                System.out.println(transaction);
            }

            // bufferedWriter.write(list.transactions.toString());
            // bufferedWriter.write("4,John,Doe\n");

            bufferedWriter.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
