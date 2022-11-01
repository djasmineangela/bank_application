package com.bank.application;

public interface Transaction {

    void deposit(int amount);
    void withdraw(int amount);
    void getStatement();
    void balance();
}
