package com.dollarsbank.exceptions;

import com.dollarsbank.utility.ColorsUtility;

public class InvalidNameException extends Exception {
    public InvalidNameException() {
        super(ColorsUtility.RED + "\nPlease enter a first and last name\n" + ColorsUtility.RESET);
    }
}
