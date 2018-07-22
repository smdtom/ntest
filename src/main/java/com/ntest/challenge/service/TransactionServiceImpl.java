package com.ntest.challenge.service;

import com.ntest.challenge.exception.OutdatedTransactionException;
import com.ntest.challenge.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService
{
    private TransactionValidator transactionValidator;

    private TransactionMapStorageService transactionMapStorageService;

    private StatisticService statisticService;

    @Autowired
    public TransactionServiceImpl(
        final TransactionValidator transactionValidator,
        final TransactionMapStorageService transactionMapStorageService,
        final StatisticService statisticService
    )
    {
        this.transactionValidator = transactionValidator;
        this.transactionMapStorageService = transactionMapStorageService;
        this.statisticService = statisticService;
    }

    @Override
    public synchronized void register(Transaction transaction)
    {
        if (transactionValidator.isTransactionOutdated(transaction.timestamp)) {
            throw new OutdatedTransactionException();
        }

        transactionMapStorageService.put(transaction);
        statisticService.update();
    }
}
