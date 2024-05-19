package com.bank;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountId, String userName, double initialBalance) {
        super(accountId, userName, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
