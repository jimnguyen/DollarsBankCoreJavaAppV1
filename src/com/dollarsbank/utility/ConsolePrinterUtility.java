package com.dollarsbank.utility;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

import java.util.Scanner;

public class ConsolePrinterUtility {
    public int welcomeMenuMessage(Scanner scanner) {
        System.out.println("+---------------------------+");
        System.out.println("| DOLLARSBANK Welcomes You! |");
        System.out.println("+---------------------------+");
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit.\n");
        System.out.println("Enter Choice (1,2 or 3) :");

        return scanner.nextInt();
    }

    public Customer newAccountMessage(Scanner scanner) {

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

        return new Customer(name, address, number, new Account(id, password, amount, new SavingsAccount()));
    }

    public void loginPromptMessage(Scanner scanner) {
        System.out.println("+---------------------+");
        System.out.println("| Enter Login Details |");
        System.out.println("+---------------------+");
        System.out.println("User Id :");
        String id = scanner.nextLine();
        System.out.println("Password :");
        String password = scanner.nextLine();
    }

    public int loginSuccessMessage(Scanner scanner) {
        System.out.println("+--------------------+");
        System.out.println("| WECOME Customer!!! |");
        System.out.println("+--------------------+");
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Funds Transfer");
        System.out.println("4. View 5 Recent Transactions");
        System.out.println("5. Display Customer Information");
        System.out.println("6. Sign Out");
        System.out.println("Enter Choice (1,2,3,4,5 or 6) :");

        return scanner.nextInt();
    }

    public double depositMessage(Scanner scanner) {
        System.out.println("Enter deposit amount:");
        return scanner.nextDouble();
    }

    public boolean withdrawMessage(Scanner scanner) {
        System.out.println("Enter withdraw amount:");
        return true;
    }
}
