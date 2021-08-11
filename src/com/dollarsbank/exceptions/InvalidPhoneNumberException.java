package com.dollarsbank.exceptions;

import com.dollarsbank.utility.ColorsUtility;

public class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException() {
        super(ColorsUtility.RED + "\nPlease enter a valid 10 digit phone number\n" + ColorsUtility.RESET);
    }
}
