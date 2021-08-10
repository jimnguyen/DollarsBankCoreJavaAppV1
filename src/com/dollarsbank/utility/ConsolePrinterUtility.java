package com.dollarsbank.utility;

import java.util.Scanner;

public class ConsolePrinterUtility {
    public static void welcomeMenuMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------------------+");
        System.out.println(ColorsUtility.BLUE + "| DOLLARSBANK Welcomes You! |");
        System.out.println(ColorsUtility.BLUE + "+---------------------------+" + ColorsUtility.RESET);
    }

    public static void newAccountMessage() {
        System.out.println(ColorsUtility.BLUE + "+-------------------------------+");
        System.out.println(ColorsUtility.BLUE + "| Enter Details For New Account |");
        System.out.println(ColorsUtility.BLUE + "+-------------------------------+" + ColorsUtility.RESET);
    }

    public static void loginPromptMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
        System.out.println(ColorsUtility.BLUE + "| Enter Login Details |");
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
    }

    public static int loginSuccessMessage(Scanner scanner) {
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
        System.out.println(ColorsUtility.BLUE + "| WELCOME Customer!!! |");
        System.out.println(ColorsUtility.BLUE + "+---------------------+" + ColorsUtility.RESET);
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Funds Transfer");
        System.out.println("4. View 5 Recent Transactions");
        System.out.println("5. Display Customer Information");
        System.out.println("6. Sign Out");
        System.out.println(ColorsUtility.GREEN + "Enter Choice (1,2,3,4,5 or 6) :" + ColorsUtility.RESET);

        return scanner.nextInt();
    }

    public static void recentTransactionsMessage(Scanner scanner) {
        System.out.println(ColorsUtility.BLUE + "+------------------------+");
        System.out.println(ColorsUtility.BLUE + "| 5 Recent Transactions: |");
        System.out.println(ColorsUtility.BLUE + "+------------------------+");
        System.out.println(ColorsUtility.RED + "FIX THIS");

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
