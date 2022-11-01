package com.bank.util;

import com.bank.application.BankAccount;
import com.bank.application.Validator;

public class TransactionValidator implements Validator {

    // public boolean containsDecimalValue() {
    //
    // }

    @Override
    public boolean isDivisibleBy100(int amount) {
        if (amount % 100 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isAmountLessThanBalance(BankAccount bankAccount, int amount) {
        if (amount < bankAccount.getBalance()) {
            return true;
        }
        return false;

    }

    @Override
    public boolean checkAmountLimit(int amount) {
        if (amount < 10_000 & amount > 0) {
            return true;
        }
        return false;
    }

}
