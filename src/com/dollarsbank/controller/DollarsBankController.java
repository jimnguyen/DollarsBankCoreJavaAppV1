package com.dollarsbank.controller;

import com.dollarsbank.model.Customer;

import java.util.List;

public class DollarsBankController {

    public List<Customer> customerList;

    public void createNewAccount(Customer customer) {
        customerList.add(customer);
    }
}
