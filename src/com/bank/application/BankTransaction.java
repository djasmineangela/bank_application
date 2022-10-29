package com.bank.application;

import com.bank.util.TransactionValidator;

public class BankTransaction extends TransactionValidator implements Validator{
    

    public void deposit(int amount) {
        if(isDivisibleBy100(amount) & checkAmountLimit(amount)) {
            
            
            //get balance
            //set balance
            setBalance(getBalance()+amount); //current balance + deposited amount
        }
        
    }
}
