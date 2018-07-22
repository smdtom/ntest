package com.ntest.challenge.service;

import com.ntest.challenge.exception.OutdatedTransactionException;
import com.ntest.challenge.model.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest
{
    @Mock
    private TransactionValidator transactionValidator;

    @Mock
    private TransactionMapStorageService transactionMapStorageService;

    @Mock
    private StatisticService statisticService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test(expected = OutdatedTransactionException.class)
    public void register_should_throw_exception_if_transaction_outdated()
    {
        long timestamp = System.currentTimeMillis();
        Transaction transaction = TransactionMapHelper.createTransaction(10.0, timestamp);

        when(transactionValidator.isTransactionOutdated(timestamp)).thenReturn(true);

        transactionService.register(transaction);
    }

    @Test
    public void register_should_put_transaction_to_storage_and_update_statistic()
    {
        long timestamp = System.currentTimeMillis();
        Transaction transaction = TransactionMapHelper.createTransaction(10.0, timestamp);

        when(transactionValidator.isTransactionOutdated(timestamp)).thenReturn(false);

        transactionService.register(transaction);

        verify(transactionMapStorageService, times(1)).put(transaction);
        verify(statisticService, times(1)).update();
    }
}
