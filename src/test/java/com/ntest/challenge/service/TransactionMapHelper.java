package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class TransactionMapHelper
{
    public static ConcurrentHashMap<Long, Transaction> createMap(List<Double> amounts)
    {
        ConcurrentHashMap<Long, Transaction> map = new ConcurrentHashMap<>();

        for (int i = 0; i < amounts.size(); i++) {
            long key = System.currentTimeMillis() + i;
            Transaction transaction = createTransaction(amounts.get(i), key);

            map.put(key, transaction);
        }

        return map;
    }

    public static Transaction createTransaction(double amount, long timestamp)
    {
        Transaction transaction = new Transaction();

        transaction.amount = amount;
        transaction.timestamp = timestamp;

        return transaction;
    }
}
