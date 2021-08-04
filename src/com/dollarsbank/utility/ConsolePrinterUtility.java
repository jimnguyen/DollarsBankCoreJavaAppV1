package com.dollarsbank.utility;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

import java.util.Scanner;

public class ConsolePrinterUtility {
    public int welcomeMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+---------------------------+");
        System.out.println("| DOLLARSBANK Welcomes You! |");
        System.out.println("+---------------------------+");
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit.\n");
        System.out.println("Enter Choice (1,2 or 3) :");
        return scanner.nextInt();
    }

    public Customer enterDetailsMessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("+-------------------------------+");
        System.out.println("| Enter Details For New Account |");
        System.out.println("+-------------------------------+");
        System.out.println("Customer Name:");
        String name = scanner.nextLine();
        System.out.println("Customer Address:");
        String address = scanner.nextLine();
        System.out.println("Customer Contact Number:");
        String number = scanner.nextLine();
        System.out.println("User Id :");
        String id = scanner.nextLine();
        System.out.println("Password : 8 Characters with Lower,Upper & Special");
        String password = scanner.nextLine();
        System.out.println("Initial Deposit Amount");
        Double amount = scanner.nextDouble();
        return new Customer(name, address, number, new Account(id, password, new SavingsAccount(amount)));
    }
}
