package com.bank.application;

public interface Validator {

    boolean isDivisibleBy100(int amount);
    boolean isAmountLessThanBalance(int amount);
//    boolean isDivisibleBy100(int amount);
}
