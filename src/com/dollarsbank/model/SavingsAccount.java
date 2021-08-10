package com.dollarsbank.model;

public class SavingsAccount {
    private Double savingsAmount;

    public SavingsAccount() {
    }

    public SavingsAccount(Double amount) {
        this.savingsAmount = amount;
    }

    public Double getSavingsAmount() {
        return savingsAmount;
    }

    public void setSavingsAmount(Double savingsAmount) {
        this.savingsAmount = savingsAmount;
    }

    @Override
    public String toString() {
        return "SavingsAccount | " +
                "savingsAmount: " + savingsAmount;
    }
}
