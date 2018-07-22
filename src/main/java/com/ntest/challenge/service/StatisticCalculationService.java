package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import java.util.concurrent.ConcurrentHashMap;

public interface StatisticCalculationService
{
    double calculateSum(ConcurrentHashMap<Long, Transaction> transactions);

    double calculateAverage(ConcurrentHashMap<Long, Transaction>transactions);

    double calculateMax(ConcurrentHashMap<Long, Transaction>transactions);

    double calculateMin(ConcurrentHashMap<Long, Transaction>transactions);
}
