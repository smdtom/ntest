package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TransactionMapStorageServiceImpl implements TransactionMapStorageService
{
    private ConcurrentHashMap<Long, Transaction> transactionsMap;

    @Autowired
    public TransactionMapStorageServiceImpl()
    {
        this.transactionsMap = new ConcurrentHashMap<>();
    }

    @Override
    public void put(Transaction transaction)
    {
        long key = System.currentTimeMillis();
        transactionsMap.put(key, transaction);
    }

    @Override
    public ConcurrentHashMap<Long, Transaction> getTransactionsMap()
    {
        return transactionsMap;
    }
}
