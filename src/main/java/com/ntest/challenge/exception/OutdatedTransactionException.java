package com.ntest.challenge.exception;

import org.springframework.http.HttpStatus;

public class OutdatedTransactionException extends BaseException
{
    private static final String ERROR_MESSAGE = "Transaction outdated";

    public OutdatedTransactionException()
    {
        super(
            HttpStatus.NO_CONTENT,
            getErrorMessage()
        );
    }

    private static String getErrorMessage()
    {
        return ERROR_MESSAGE;
    }
}
