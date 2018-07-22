package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;

import java.util.concurrent.ConcurrentHashMap;

public interface TransactionMapStorageService
{
    void put(Transaction transaction);

    ConcurrentHashMap<Long, Transaction> getTransactionsMap();
}
