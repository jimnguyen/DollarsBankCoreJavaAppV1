package com.dollarsbank.model;

public class Account {
    private String id;
    private String password;
    private SavingsAccount savingsAccount;

    public Account() {
    }

    public Account(String id, String password, SavingsAccount savingsAccount) {
        this.id = id;
        this.password = password;
        this.savingsAccount = savingsAccount;
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

    public SavingsAccount getSavingsAccount() {
        return savingsAccount;
    }

    public void setSavingsAccount(SavingsAccount savingsAccount) {
        this.savingsAccount = savingsAccount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", savingsAccount=" + savingsAccount +
                '}';
    }
}
