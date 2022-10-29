package com.bank.application;

import java.util.ArrayList;
import java.util.List;

public class TransactionList {
    List<Character> operators;
    List<Integer> amounts;
    int total;
//    BankAccount bankAccount;
    
    public int getTotal() {
        return total;
    }


    public TransactionList() {
        // TODO Auto-generated constructor stub
        operators = new ArrayList<Character>();
        amounts = new ArrayList<Integer>();
//        bankAccount = new BankAccount();
     
    }
    
    
    public int calculateBalance() {
        int total = 0;
        for (int i = 0; i < this.operators.size(); i++) {
            if (this.operators.get(i).equals('+')) {
                total += this.amounts.get(i);
            } else {
                total -= this.amounts.get(i);
            }
        }
        System.out.println("Total " + total);
        this.total = total;
//        bankAccount.setBalance(total);
        return total;
    }
    
    public int parseOperator(List <String> transactions) {
        for (String transaction : transactions) {
            this.operators.add(transaction.charAt(0));
            String getAmount = transaction.substring(1);
            int amount = Integer.parseInt(getAmount);
            this.amounts.add(amount);
        }
        int total = calculateBalance();
        return total;
        
    }
    
    public void add(char operator, int amount) {
        if (operator == '+') {
            operators.add('+');
        } else {
            operators.add('-');
        }
        amounts.add(amount);
    }
    
    
}
