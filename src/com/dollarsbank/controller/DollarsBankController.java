package com.dollarsbank.controller;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ColorsUtility;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class DollarsBankController {

    public void createAccount(List<Customer> customers, Customer customer) {
        customers.add(customer);
    }

    public void addAccount(Set<Account> accounts, Account account) {
        accounts.add(account);
    }

    public Account getAccount(Set<Account> accounts, String id, String password) {
        for (Account account : accounts) {
            if (account.getId().equals(id) && account.getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public boolean checkLogin(Set<Account> accounts, String id, String password) {
        for (Account account : accounts) {
            if (account.getId().equals(id)) {
                return account.getPassword().equals(password);
            }
        }
        return false;
    }

    public void deposit(Account account, Double amount) {
        account.setCheckingAmount(account.getCheckingAmount() + amount);
        System.out.printf("%nYou have successfully deposited " + ColorsUtility.YELLOW + "$%.2f" + ColorsUtility.RESET + " into your account!%n", amount);
        System.out.printf("Your new balance is now " + ColorsUtility.YELLOW +  "$%.2f%n" + ColorsUtility.RESET, account.getCheckingAmount());

        List<String> transactions = account.getTransactions();
        transactions.add("Deposited " + amount + " into CHECKING account on " + new Date());
        account.setTransactions(transactions);
    }

    public void display(List<Customer> customers, Account account) {
        Customer current = null;
        for (Customer customer : customers) {
            if (customer.getAccount().equals(account)) {
                current = customer;
                break;
            }
        }

        assert current != null;
        System.out.printf("User ID: %s | Name: %s | Address: %s | Number: %s | Checking Amount: $%.2f%n",
                account.getId(),
                current.getName(),
                current.getAddress(),
                current.getNumber(),
                account.getCheckingAmount());
    }

    public void withdraw(Account account, Double amount) {
        if (account.getCheckingAmount() < amount) {
            System.out.println(ColorsUtility.RED + "Insufficient funds! Please try again." + ColorsUtility.RESET);
            return;
        }

        account.setCheckingAmount(account.getCheckingAmount() - amount);
        System.out.printf("%nYou have successfully withdrawn " + ColorsUtility.YELLOW + "$%.2f" + ColorsUtility.RESET + " from your account!%n", amount);
        System.out.printf("Your new balance is now " + ColorsUtility.YELLOW + "$%.2f%n" + ColorsUtility.RESET, account.getCheckingAmount());

        List<String> transactions = account.getTransactions();
        transactions.add("Withdrew " + amount + " from CHECKING account on " + new Date());
    }

    public void checkingTransfer(Account account, Double amount) {
        if (account.getSavingsAccount() == null) {
            account.setSavingsAccount(new SavingsAccount(0.0));
        }

        if (account.getCheckingAmount() < amount) {
            System.out.println(ColorsUtility.RED + "Insufficient funds! Please try again." + ColorsUtility.RESET + "\n");
            return;
        }

        // Transfer and update from checking account
        SavingsAccount savingsAccount = account.getSavingsAccount();
        savingsAccount.setSavingsAmount(savingsAccount.getSavingsAmount() + amount);
        account.setCheckingAmount(account.getCheckingAmount() - amount);

        System.out.printf("%nYou have successfully transferred " + ColorsUtility.YELLOW + "$%.2f" + ColorsUtility.RESET + " from your CHECKING account!%n", amount);
        System.out.printf("Your new SAVINGS balance is now " + ColorsUtility.YELLOW + "$%.2f%n" + ColorsUtility.RESET, savingsAccount.getSavingsAmount());
        System.out.printf("Your new CHECKING balance is now " + ColorsUtility.YELLOW + "$%.2f%n" + ColorsUtility.RESET, account.getCheckingAmount());

        List<String> transactions = account.getTransactions();
        transactions.add("Transferred " + amount + " into SAVINGS account on " + new Date());
    }

    public void savingsTransfer(Account account, Double amount) {
        if (account.getSavingsAccount().getSavingsAmount() < amount || account.getSavingsAccount() == null) {
            System.out.println(ColorsUtility.RED + "Insufficient funds! Please try again." + ColorsUtility.RESET + "\n");
            return;
        }

        // Transfer and update from savings account
        SavingsAccount savingsAccount = account.getSavingsAccount();
        savingsAccount.setSavingsAmount(savingsAccount.getSavingsAmount() - amount);
        account.setCheckingAmount(account.getCheckingAmount() + amount);
        System.out.printf("%nYou have successfully transferred " + ColorsUtility.YELLOW + "$%.2f" + ColorsUtility.RESET + " from your SAVINGS account!%n", amount);
        System.out.printf("Your new CHECKING balance is now " + ColorsUtility.YELLOW + "$%.2f%n" + ColorsUtility.RESET, account.getCheckingAmount());
        System.out.printf("Your new SAVINGS balance is now " + ColorsUtility.YELLOW + "$%.2f%n" + ColorsUtility.RESET, savingsAccount.getSavingsAmount());

        List<String> transactions = account.getTransactions();
        transactions.add("Transferred " + amount + " into CHECKING account on " + new Date());
    }
}
