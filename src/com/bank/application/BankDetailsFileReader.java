package com.bank.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BankDetailsFileReader extends TransactionList {
    FileReader fileReader = null;
    BufferedReader reader = null;
    
    public static File setFileName () {
        return new File("C:\\Users\\deljas\\Documents\\GitHub\\bank_application\\src\\bankFiles\\bankStatement.txt");
    }

    public List<String> read() {
        List<String> transactions = new ArrayList<>();
        try {

            File bankStatement = setFileName();
            
            fileReader = new FileReader(bankStatement);
            reader = new BufferedReader(fileReader);
            

            if (bankStatement.exists()) {
                String line = null;// +1000
                while ((line = reader.readLine()) != null) { // read
                    transactions.add(line); // storing
                }

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
