package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;

import java.util.List;
import java.util.Set;

public class DollarsBankController {

    public void createAccount(List<Customer> customers, Customer customer) {
        customers.add(customer);
    }

    public void addAccount(Set<Account> accounts, Account account) {
        accounts.add(account);
    }

    public boolean checkLogin(Set<Account> accounts, String id, String password) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                return account.getPassword().equals(password);
            }
        }
        return false;
    }
}
