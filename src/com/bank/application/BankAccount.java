package com.bank.application;

public class BankAccount {
    private int balance;

    public BankAccount() {

    }

    public int getBalance() { // current balance
        return balance;
    }

    public void setBalance(int balance) {
        System.out.println("set : " + balance);
        this.balance = balance;
    }

}
