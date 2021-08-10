package com.dollarsbank.model;

public class Customer {
    private String name;
    private String address;
    private String number;
    private Account account;

    public Customer() {
    }

    public Customer(String name, String address, String number, Account account) {
        this.name = name;
        this.address = address;
        this.number = number;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer | " + "name: " + name + " | address: " + address + " | number: " + number + " | account: " + account;
    }
}
