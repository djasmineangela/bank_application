package com.bank.application;

public interface Validator {

    boolean isDivisibleBy100(int amount);
    boolean isAmountLessThanBalance(BankAccount bankAccount, int amount);
    boolean checkAmountLimit(int amount);
}
