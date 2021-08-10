package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;
import com.dollarsbank.utility.ColorsUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DollarsBankApplication {

    public static DollarsBankController dollarsBankController = new DollarsBankController();

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Jim", "123 React Lane", "1231231233", new Account("U123", "password", 5000.00)));
        try (Scanner scanner = new Scanner(System.in)) {
            start(scanner, customers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start(Scanner scanner, List<Customer> customers) {
        int option;
        while (true) {
            option = welcome(scanner);
            switch (option) {
                case 1 -> createAccount(scanner, customers);
                case 2 -> login(scanner, customers);
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
        System.out.println(ColorsUtility.RESET + "1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit.\n");
        System.out.println(ColorsUtility.GREEN + "Enter Choice (1,2 or 3) :" + ColorsUtility.RESET);
        return scanner.nextInt();
    }

    public static void createAccount(Scanner scanner, List<Customer> customers) {
        scanner.nextLine();
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
        Customer customer = new Customer(name, address, number, new Account(id, password, amount));
        dollarsBankController.createAccount(customers, customer);
    }

    public static void login(Scanner scanner, List<Customer> customers) {
        System.out.println("User Id :");
        String id = scanner.nextLine();
        System.out.println("Password :");
        String password = scanner.nextLine();
    }
}
