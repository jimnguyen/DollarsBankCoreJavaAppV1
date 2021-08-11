package com.dollarsbank.model;

import java.util.List;

public class Account {
    private String id;
    private String password;
    private Double checkingAmount;
    private SavingsAccount savingsAccount;
    private List<String> transactions;

    public Account() {
    }

    public Account(String id, String password, Double checkingAmount) {
        this.id = id;
        this.password = password;
        this.checkingAmount = checkingAmount;
    }

    public Account(String id, String password, Double checkingAmount, SavingsAccount savingsAccount) {
        this.id = id;
        this.password = password;
        this.checkingAmount = checkingAmount;
        this.savingsAccount = savingsAccount;
    }

    public Account(String id, String password, Double checkingAmount, SavingsAccount savingsAccount, List<String> transactions) {
        this.id = id;
        this.password = password;
        this.checkingAmount = checkingAmount;
        this.savingsAccount = savingsAccount;
        this.transactions = transactions;
    }

    public Account(String id, String password, Double checkingAmount, List<String> transactions) {
        this.id = id;
        this.password = password;
        this.checkingAmount = checkingAmount;
        this.transactions = transactions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCheckingAmount() {
        return checkingAmount;
    }

    public void setCheckingAmount(Double checkingAmount) {
        this.checkingAmount = checkingAmount;
    }

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "[Account | " +
                "id: " + id + " | password='" + password + " | checkingAmount=" + checkingAmount + " | savingsAccount: " + savingsAccount + "]";
    }
}
