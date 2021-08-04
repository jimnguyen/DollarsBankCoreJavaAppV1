package com.dollarsbank.model;

public class SavingsAccount {
    private Double amount;

    public SavingsAccount() {
    }

    public SavingsAccount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "amount=" + amount +
                '}';
    }
}
