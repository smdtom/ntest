package com.ntest.challenge.service;

import com.ntest.challenge.model.Statistic;
import com.ntest.challenge.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StatisticServiceImpl implements StatisticService
{
    private volatile Statistic statistic;

    private StatisticCalculationService statisticCalculationService;

    private TransactionMapStorageService transactionMapStorageService;

    @Autowired
    public StatisticServiceImpl(
        final StatisticCalculationService statisticCalculationService,
        final TransactionMapStorageService transactionMapStorageService
    )
    {
        this.statistic = new Statistic();
        this.statisticCalculationService = statisticCalculationService;
        this.transactionMapStorageService = transactionMapStorageService;
    }

    @Override
    public Statistic getStatistic()
    {
        return statistic;
    }

    @Override
    public synchronized void update()
    {
        ConcurrentHashMap<Long, Transaction>transactions = transactionMapStorageService.getTransactionsMap();

        statistic.setSum(statisticCalculationService.calculateSum(transactions));
        statistic.setAvg(statisticCalculationService.calculateAverage(transactions));
        statistic.setMax(statisticCalculationService.calculateMax(transactions));
        statistic.setMin(statisticCalculationService.calculateMin(transactions));
        statistic.setCount(transactions.size());
    }
}
