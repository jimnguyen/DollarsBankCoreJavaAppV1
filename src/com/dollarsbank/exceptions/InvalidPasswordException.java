package com.dollarsbank.exceptions;

import com.dollarsbank.utility.ColorsUtility;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super(ColorsUtility.RED + "\nPlease enter a valid password\n" + ColorsUtility.RESET);
    }
}
