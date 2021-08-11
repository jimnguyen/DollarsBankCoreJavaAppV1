package com.dollarsbank.application;

import com.dollarsbank.controller.DollarsBankController;
import com.dollarsbank.exceptions.InvalidInformationException;
import com.dollarsbank.exceptions.InvalidNameException;
import com.dollarsbank.exceptions.InvalidPasswordException;
import com.dollarsbank.exceptions.InvalidPhoneNumberException;
import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.utility.ColorsUtility;
import com.dollarsbank.utility.ConsolePrinterUtility;

import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DollarsBankApplication {

    public static DollarsBankController dollarsBankController = new DollarsBankController();

    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        Set<Account> accounts = new HashSet<>();
        try (Scanner scanner = new Scanner(System.in)) {
            start(scanner, customers, accounts);
        } catch (InputMismatchException e) {
            System.out.println("\nPlease enter a valid option.");
        }
    }

    public static void start(Scanner scanner, List<Customer> customers, Set<Account> accounts) {
        int option = 0;
        while (option != 3) {
            option = welcome(scanner);
            switch (option) {
                case 1 -> createAccount(scanner, customers, accounts);
                case 2 -> login(scanner, customers, accounts);
                case 3 -> {
                    System.out.println("\nYou are now exiting DOLLARSBANK.");
                    System.out.println("Goodbye!");
                    System.exit(1);
                }
                default -> {
                    System.out.println("Please select a valid option.\n");
                    start(scanner, customers, accounts);
                }
            }
        }
    }

    public static int welcome(Scanner scanner) {
        ConsolePrinterUtility.welcomeMenuMessage();
        return scanner.nextInt();
    }

    public static void createAccount(Scanner scanner, List<Customer> customers, Set<Account> accounts) {
        System.out.println();
        ConsolePrinterUtility.newAccountMessage();
        scanner.nextLine();

        try {
            // Retrieve new customer account information
            System.out.println("Customer Name:");
            String name = scanner.nextLine();
            if (name.split(" ").length < 2) {
                throw new InvalidNameException();
            }

            System.out.println("Customer Address:");
            String address = scanner.nextLine();
            if (address.length() == 0) {
                throw new InvalidInformationException();
            }

            System.out.println("Customer Contact Number (10 Digits):");
            String number = scanner.nextLine();
            if (number.length() != 10) {
                throw new InvalidPhoneNumberException();
            }

            System.out.println("User Id:");
            String id = scanner.nextLine();
            System.out.println("Password (8 Characters with Lower, Upper & Special):");
            String password = scanner.nextLine();
            String regex = "^(?=.*[a-z])(?=."
                    + "*[A-Z])(?=.*\\d)"
                    + "(?=.*[-+_!@#$%^&*., ?]).+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            if (!matcher.matches() || password.length() < 8) {
                throw new InvalidPasswordException();
            }

            System.out.println("Initial Deposit Amount:");
            double amount = scanner.nextDouble();
            if (amount == 0) {
                throw new ArithmeticException("Please enter an amount greater than 0");
            }

            // Use controller to add to "database"
            List<String> transactions = new ArrayList<>();
            transactions.add("Initial Deposit Amount in account [" + id + "]. Balance - " + amount + " as on " + new Date());
            Account account = new Account(id.trim(), password.trim(), amount, transactions);
            Customer customer = new Customer(name.trim(), address.trim(), number.trim(), account);

            dollarsBankController.createAccount(customers, customer);
            dollarsBankController.addAccount(accounts, account);
        } catch (InputMismatchException | InvalidInformationException | InvalidPhoneNumberException | InvalidPasswordException | InvalidNameException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void login(Scanner scanner, List<Customer> customers, Set<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("Please create an account.\n");
            return;
        }

        System.out.println();
        ConsolePrinterUtility.loginPromptMessage();

        // Retrieve user login information
        scanner.nextLine();
        System.out.println("User Id :");
        String id = scanner.nextLine();
        System.out.println(ColorsUtility.RESET + "Password :");
        String password = scanner.nextLine();
        boolean valid = dollarsBankController.checkLogin(accounts, id, password);

        if (valid) {
            Account account = dollarsBankController.getAccount(accounts, id, password);
            welcomeCustomer(scanner, customers, account, accounts);
        } else {
            System.out.println(ColorsUtility.RED + "Invalid Credentials. Try Again!\n" + ColorsUtility.RESET);
        }
    }

    public static void welcomeCustomer(Scanner scanner, List<Customer> customers, Account account, Set<Account> accounts) {
        int option = 0;
        try {
            while (option != 6) {
                ConsolePrinterUtility.loginSuccessMessage();
                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1 -> deposit(scanner, account);
                    case 2 -> withdraw(scanner, account);
                    case 3 -> fundsTransfer(scanner, customers, account, accounts);
                    case 4 -> recentTransactions(account);
                    case 5 -> display(customers, account);
                    case 6 -> {
                        System.out.println("You are signing out now... Goodbye!\n");
                        start(scanner, customers, accounts);
                    }
                    default -> System.out.println("Please select a valid option");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please provide valid input\n");
        }
    }

    private static void deposit(Scanner scanner, Account account) {
        ConsolePrinterUtility.depositMessage();
        Double amount = scanner.nextDouble();
        dollarsBankController.deposit(account, amount);
    }

    private static void withdraw(Scanner scanner, Account account) {
        ConsolePrinterUtility.withdrawMessage();
        Double amount = scanner.nextDouble();
        dollarsBankController.withdraw(account, amount);
    }

    private static void fundsTransfer(Scanner scanner, List<Customer> customers, Account account, Set<Account> accounts) {
        int option = 0;
        while (option != 3) {
            ConsolePrinterUtility.fundsTransferMessage();
            option = scanner.nextInt();
            switch (option) {
                case 1 -> transferChecking(scanner, account);
                case 2 -> transferSavings(scanner, account);
                case 3 -> welcomeCustomer(scanner, customers, account, accounts);
                default -> System.out.println("Please select a valid option\n");
            }
        }
    }

    private static void transferChecking(Scanner scanner, Account account) {
        ConsolePrinterUtility.checkingTransferMessage();
        System.out.printf("Current CHECKING balance: " + ColorsUtility.YELLOW + "%.2f" + ColorsUtility.RESET, account.getCheckingAmount());
        System.out.println("\nEnter transfer amount:");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println(ColorsUtility.RED + "\nPlease enter a value greater than 0\n" + ColorsUtility.RESET);
            return;
        }

        dollarsBankController.checkingTransfer(account, amount);
    }

    private static void transferSavings(Scanner scanner, Account account) {
        ConsolePrinterUtility.savingsTransferMessage();

        if (account.getSavingsAccount() == null) {
            System.out.println(ColorsUtility.RED + "SAVINGS account has not been created yet");
            System.out.println("Please transfer funds from CHECKING account to create SAVINGS account\n" + ColorsUtility.RESET);
            return;
        }

        System.out.printf("Current SAVINGS balance: " + ColorsUtility.YELLOW + "%.2f" + ColorsUtility.RESET, account.getSavingsAccount().getSavingsAmount());
        System.out.println("\nEnter transfer amount:");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println(ColorsUtility.RED + "\nPlease enter a value greater than 0\n" + ColorsUtility.RESET);
            return;
        }

        dollarsBankController.savingsTransfer(account, amount);
    }

    private static void recentTransactions(Account account) {
        List<String> transactions = account.getTransactions();
        ConsolePrinterUtility.recentTransactionsMessage();
        int number = 1;
        for (int i = 0; i < transactions.size(); i++) {
            if (number == 6) {
                return;
            }
            System.out.println(number++ + ". " + transactions.get(i));
        }
    }

    private static void display(List<Customer> customers, Account account) {
        ConsolePrinterUtility.displayMessage();
        dollarsBankController.display(customers, account);
    }
}
