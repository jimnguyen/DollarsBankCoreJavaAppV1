package com.dollarsbank.controller;

import com.dollarsbank.model.Customer;

import java.util.List;

public class DollarsBankController {

    public void createAccount(List<Customer> customerList, Customer customer) {
        customerList.add(customer);
    }
}
