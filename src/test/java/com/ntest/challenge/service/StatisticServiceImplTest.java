package com.ntest.challenge.service;

import com.ntest.challenge.model.Statistic;
import com.ntest.challenge.model.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticServiceImplTest
{
    @Mock
    private StatisticCalculationService statisticCalculationService;

    @Mock
    private TransactionMapStorageService transactionMapStorageService;

    @InjectMocks
    private StatisticServiceImpl statisticService;

    @Test
    public void update_should_change_statistic()
    {
        List<Double> amounts = new ArrayList<>();
        amounts.add(5.0);
        amounts.add(15.0);
        ConcurrentHashMap<Long, Transaction> transactionMap = TransactionMapHelper.createMap(amounts);
        Double average = 10.0;
        Double max = 15.0;
        Double min = 5.0;
        Double sum = 20.0;
        int count = amounts.size();

        when(transactionMapStorageService.getTransactionsMap()).thenReturn(transactionMap);
        when(statisticCalculationService.calculateSum(transactionMap)).thenReturn(sum);
        when(statisticCalculationService.calculateAverage(transactionMap)).thenReturn(average);
        when(statisticCalculationService.calculateMax(transactionMap)).thenReturn(max);
        when(statisticCalculationService.calculateMin(transactionMap)).thenReturn(min);

        statisticService.update();

        Statistic statistic = statisticService.getStatistic();

        assertEquals(average, statistic.getAvg(), 0);
        assertEquals(max, statistic.getMax(), 0);
        assertEquals(min, statistic.getMin(), 0);
        assertEquals(sum, statistic.getSum(), 0);
        assertEquals(count, statistic.getCount(), 0);
    }
}
