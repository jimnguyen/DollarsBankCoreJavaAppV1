package com.dollarsbank.utility;

public class ConsolePrinterUtility {
    public static void welcomeMenuMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------------------+");
        System.out.println(ColorsUtility.BLUE + "| DOLLARSBANK Welcomes You! |");
        System.out.println(ColorsUtility.BLUE + "+---------------------------+" + ColorsUtility.RESET);
        System.out.println("1. Create New Account");
        System.out.println("2. Login");
        System.out.println("3. Exit.\n");
        System.out.println(ColorsUtility.GREEN + "Enter Choice (1, 2 or 3) :" + ColorsUtility.RESET);
    }

    public static void newAccountMessage() {
        System.out.println(ColorsUtility.BLUE + "+-------------------------------+");
        System.out.println(ColorsUtility.BLUE + "| Enter Details For New Account |");
        System.out.println(ColorsUtility.BLUE + "+-------------------------------+" + ColorsUtility.RESET);
    }

    public static void loginPromptMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
        System.out.println(ColorsUtility.BLUE + "| Enter Login Details |");
        System.out.println(ColorsUtility.BLUE + "+---------------------+" + ColorsUtility.RESET);
    }

    public static void loginSuccessMessage() {
        System.out.println();
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
        System.out.println(ColorsUtility.BLUE + "| WELCOME Customer!!! |");
        System.out.println(ColorsUtility.BLUE + "+---------------------+" + ColorsUtility.RESET);
        System.out.println("1. Deposit Amount");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Funds Transfer");
        System.out.println("4. View 5 Recent Transactions");
        System.out.println("5. Display Customer Information");
        System.out.println("6. Sign Out\n");
        System.out.println(ColorsUtility.GREEN + "Enter Choice (1, 2, 3, 4, 5 or 6) :" + ColorsUtility.RESET);
    }

    public static void recentTransactionsMessage() {
        System.out.println(ColorsUtility.BLUE + "+------------------------+");
        System.out.println(ColorsUtility.BLUE + "| 5 Recent Transactions: |");
        System.out.println(ColorsUtility.BLUE + "+------------------------+" + ColorsUtility.RESET);
    }

    public static void depositMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------+");
        System.out.println(ColorsUtility.BLUE + "| DEPOSIT MONEY |");
        System.out.println(ColorsUtility.BLUE + "+---------------+" + ColorsUtility.RESET);
        System.out.println("Enter deposit amount:");
    }

    public static void displayMessage() {
        System.out.println(ColorsUtility.BLUE + "+---------------------+");
        System.out.println(ColorsUtility.BLUE + "| DISPLAY INFORMATION |");
        System.out.println(ColorsUtility.BLUE + "+---------------------+" + ColorsUtility.RESET);
        System.out.println("Your information:");
    }

    public static void withdrawMessage() {
        System.out.println(ColorsUtility.BLUE + "+----------------+");
        System.out.println(ColorsUtility.BLUE + "| WITHDRAW MONEY |");
        System.out.println(ColorsUtility.BLUE + "+----------------+" + ColorsUtility.RESET);
        System.out.println("Enter withdraw amount:");
    }

    public static void fundsTransferMessage() {
        System.out.println(ColorsUtility.BLUE + "+----------------+");
        System.out.println(ColorsUtility.BLUE + "| FUNDS TRANSFER |");
        System.out.println(ColorsUtility.BLUE + "+----------------+" + ColorsUtility.RESET);
        System.out.println("Select which account you would like to transfer from:\n");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Exit");
        System.out.println("\nEnter option here (1, 2 or 3):");
    }

    public static void checkingTransferMessage() {
        System.out.println(ColorsUtility.BLUE + "+------------------------------+");
        System.out.println(ColorsUtility.BLUE + "| CHECKING TO SAVINGS TRANSFER |");
        System.out.println(ColorsUtility.BLUE + "+------------------------------+" + ColorsUtility.RESET);
    }

    public static void savingsTransferMessage() {
        System.out.println(ColorsUtility.BLUE + "+------------------------------+");
        System.out.println(ColorsUtility.BLUE + "| SAVINGS TO CHECKING TRANSFER |");
        System.out.println(ColorsUtility.BLUE + "+------------------------------+" + ColorsUtility.RESET);
    }
}
