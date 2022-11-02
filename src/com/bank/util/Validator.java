package com.bank.util;

import com.bank.application.BankAccount;

public interface Validator {

    boolean isDivisibleBy100(int amount);
    boolean isAmountLessThanBalance(BankAccount bankAccount, int amount);
    boolean checkAmountLimit(int amount);
}
