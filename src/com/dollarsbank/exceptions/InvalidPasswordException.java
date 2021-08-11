package com.dollarsbank.exceptions;

import com.dollarsbank.utility.ColorsUtility;

public class InvalidPasswordException extends Exception {
    public InvalidPasswordException() {
        super(ColorsUtility.RED + "\nPlease enter a password of at least 8 characters\n" + ColorsUtility.RESET);
    }
}
