package com.bank.application;

public class BankAccount implements Account{
    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }
}

