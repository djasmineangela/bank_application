package com.bank.util;

import com.bank.application.BankAccount;
import com.bank.application.Validator;
//import com.bank.application.Validator;

public class TransactionValidator extends BankAccount implements Validator {
    
//    public boolean containsDecimalValue() {
//        
//    }
    
    
    
    
    public boolean isDivisibleBy100(int amount) {
        if(amount%100 == 0) {
            return true;
        }
        return false;
    }
    
    public boolean isAmountLessThanBalance(int amount) {
        if(amount < getBalance()) {
            return true;
        }
        
        return false;
        
    }
    
    public boolean checkAmountLimit(int amount) {
        if (amount < 10_000 & amount > 0) {
            return true;
        }
         return false;
    }
}
