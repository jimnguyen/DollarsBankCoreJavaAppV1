package com.dollarsbank.model;

public class SavingsAccount {
    private Double savingsAmount;

    public SavingsAccount() {
    }

    public SavingsAccount(Double amount) {
        this.savingsAmount = amount;
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "savingsAmount=" + savingsAmount +
                '}';
    }
}
