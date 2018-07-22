package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class TransactionMapUpdateServiceImpl implements TransactionMapUpdateService
{
    private TransactionMapStorageService transactionMapStorageService;

    private StatisticService statisticService;

    private TransactionValidator transactionValidator;

    private boolean refreshLocked = false;

    @Autowired
    public TransactionMapUpdateServiceImpl(
        final TransactionMapStorageService transactionMapStorageService,
        final StatisticService statisticService,
        final TransactionValidator transactionValidator
    )
    {
        this.transactionMapStorageService = transactionMapStorageService;
        this.statisticService = statisticService;
        this.transactionValidator = transactionValidator;
    }

    @Override
    @Scheduled(fixedRate = 2000)
    public void refreshMap()
    {
        if (!refreshLocked) {
            refreshLocked = true;
            boolean needRefreshStatistic = false;
            ConcurrentHashMap<Long, Transaction> transactionsMap = transactionMapStorageService.getTransactionsMap();

            for (Long timestamp : transactionsMap.keySet()) {
                if (transactionValidator.isTransactionOutdated(timestamp)) {
                    transactionsMap.remove(timestamp);
                    needRefreshStatistic = true;
                }
            }

            if (needRefreshStatistic) {
                statisticService.update();
            }

            refreshLocked = false;
        }
    }
}
