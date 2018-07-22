package com.ntest.challenge.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionValidatorImpl implements TransactionValidator
{
    public static final int TTL_MS = 60000;

    @Override
    public boolean isTransactionOutdated(long timestamp)
    {
        long oneMinuteAgo = System.currentTimeMillis() - TTL_MS;

        return oneMinuteAgo > timestamp;
    }
}
