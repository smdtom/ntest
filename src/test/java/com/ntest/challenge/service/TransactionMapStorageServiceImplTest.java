package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TransactionMapStorageServiceImplTest
{
    private TransactionMapStorageServiceImpl transactionMapStorageService;

    @Before
    public void setUp()
    {
        this.transactionMapStorageService = new TransactionMapStorageServiceImpl();
    }

    @Test
    public void put_should_add_transaction_to_map()
    {
        double amount = 10.0;
        long timestamp = System.currentTimeMillis();
        Transaction transaction = TransactionMapHelper.createTransaction(amount, timestamp);

        transactionMapStorageService.put(transaction);
        ConcurrentHashMap<Long, Transaction> transactionsMap = transactionMapStorageService.getTransactionsMap();

        assertEquals(1, transactionsMap.size());
    }
}
