package com.ntest.challenge.service;

public interface TransactionValidator
{
    boolean isTransactionOutdated(long timestamp);
}
