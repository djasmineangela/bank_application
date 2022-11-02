package com.bank.application;

import java.util.ArrayList;
import java.util.List;

public class TransactionList extends BankAccount {
    private List<Character> operators;
    private List<Integer> amounts;
    private List<String> transactions;

    int total;
    // BankAccount bankAccount;

    public int getTotal() {
        return total;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
        parseOperator(); // put to separate lists
    }

    public TransactionList() {
        // TODO Auto-generated constructor stub
        operators = new ArrayList<Character>();
        amounts = new ArrayList<Integer>();
        transactions = new ArrayList<String>();
        // bankAccount = new BankAccount();

    }

    public TransactionList(List<String> transactions) {
        this.transactions = transactions;

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
        // bankAccount.setBalance(total);
        return total;
    }

    private void parseOperator() {
        for (String transaction : this.transactions) {
            this.operators.add(transaction.charAt(0));
            String getAmount = transaction.substring(1);
            int amount = Integer.parseInt(getAmount);
            this.amounts.add(amount);
        }
        // int total = calculateBalance();
        // setBalance(total);
        // return total;

    }

    // public void add(char operator, int amount) {
    // if (operator == '+') {
    // operators.add('+');
    // } else {
    // operators.add('-');
    // }
    // amounts.add(amount);
    // }

    public void add(String transaction) {
        transactions.add(transaction);
        int amount = Integer.parseInt(transaction.substring(1));
        if (transaction.charAt(0) == '+') {
            total += amount;
        } else {
            total -= amount;
        }
    }

}
