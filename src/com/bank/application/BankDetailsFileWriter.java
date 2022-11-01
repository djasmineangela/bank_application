package com.bank.application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BankDetailsFileWriter {
    
    public static void updateBankStatement(List<String> transactions) {        
        File bankStatement = BankDetailsFileReader.setFileName();

        FileWriter fileWriter;
        PrintWriter out;
        try {

            if (bankStatement.exists()) {
                bankStatement.delete();
            }
            
            bankStatement.createNewFile();
            fileWriter = new FileWriter(bankStatement, false);
            out = new PrintWriter(fileWriter);
            for (String transaction : transactions) {
                out.println(transaction);
            }
            out.flush();
            out.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
