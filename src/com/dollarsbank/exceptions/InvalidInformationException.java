package com.dollarsbank.exceptions;

import com.dollarsbank.utility.ColorsUtility;

public class InvalidInformationException extends Exception {
    public InvalidInformationException() {
        super(ColorsUtility.RED + "\nPlease enter valid information\n" + ColorsUtility.RESET);
    }
}
