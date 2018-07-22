package com.ntest.challenge.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class TransactionValidatorImplTest
{
    private TransactionValidatorImpl transactionValidator;

    @Before
    public void setUp()
    {
        this.transactionValidator = new TransactionValidatorImpl();
    }

    @Test
    public void isTransactionOutdated_should_return_true()
    {
        long timestamp = System.currentTimeMillis() - TransactionValidatorImpl.TTL_MS - 1;
        boolean result = transactionValidator.isTransactionOutdated(timestamp);

        assertTrue(result);
    }

    @Test
    public void isTransactionOutdated_should_return_false()
    {
        long timestamp = System.currentTimeMillis();
        boolean result = transactionValidator.isTransactionOutdated(timestamp);

        assertFalse(result);
    }
}
