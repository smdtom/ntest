package com.ntest.challenge.exception;

import org.springframework.http.HttpStatus;

public class BaseException extends RuntimeException
{
    private final HttpStatus statusCode;

    public BaseException(HttpStatus statusCode, String message)
    {
        super(message);

        this.statusCode = statusCode;
    }

    public HttpStatus getStatusCode()
    {
        return statusCode;
    }

    @Override
    public String toString()
    {
        return String.format("BaseException [statusCode=%s]", getStatusCode());
    }
}

