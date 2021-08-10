package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

import java.util.*;

public class DollarsBankApplication {

    public static DollarsBankController dollarsBankController = new DollarsBankController();
    public static ConsolePrinterUtility consolePrinterUtility = new ConsolePrinterUtility();

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Set<Account> accounts = new HashSet<>();
        Account tempAccount = new Account("U123", "password", 5000.00);
        accounts.add(tempAccount);
        Customer tempCustomer = new Customer("Jim", "123 React Lane", "1231231233", tempAccount);
        customers.add(tempCustomer);
        try (Scanner scanner = new Scanner(System.in)) {
            start(scanner, customers, accounts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start(Scanner scanner, List<Customer> customers, Set<Account> accounts) {
        int option;
        while (true) {
            option = welcome(scanner);
            switch (option) {
                case 1 -> createAccount(scanner, customers, accounts);
                case 2 -> login(scanner, accounts);
                case 3 -> {
                    System.out.println("\nYou are now exiting DOLLARSBANK.");
                    System.out.println("Goodbye!");
                    System.exit(1);
                }
                case 4 -> System.out.println("\n" + customers);
                default -> System.out.println("Please select a valid option.\n");
            }
        }

    }

    public static int welcome(Scanner scanner) {
        ConsolePrinterUtility.welcomeMenuMessage();
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit.\n");
        System.out.println(ColorsUtility.GREEN + "Enter Choice (1,2 or 3) :" + ColorsUtility.RESET);
        return scanner.nextInt();
    }

    public static void createAccount(Scanner scanner, List<Customer> customers, Set<Account> accounts) {
        System.out.println();
        ConsolePrinterUtility.newAccountMessage();
        scanner.nextLine();

        // Retrieve new customer account information
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

        // Use controller to add to "database"
        Account account = new Account(id, password, amount);
        Customer customer = new Customer(name, address, number, account);
        dollarsBankController.createAccount(customers, customer);
        dollarsBankController.addAccount(accounts, account);
    }

    public static void login(Scanner scanner, Set<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("Please create an account.\n");
            return;
        }

        // Retrieve user login information
        scanner.nextLine();
        System.out.println("\nUser Id :");
        String id = scanner.nextLine();
        System.out.println(ColorsUtility.RESET + "Password :");
        String password = scanner.nextLine();
        boolean valid = dollarsBankController.checkLogin(accounts, id, password);

        if (valid) {
            welcomeCustomer(scanner);
        } else {
            System.out.println(ColorsUtility.RED + "Invalid Credentials. Try Again!\n" + ColorsUtility.RESET);
        }
    }

    public static void welcomeCustomer(Scanner scanner) {
        System.out.println("WELCOME CUSTOMER");
    }
}
