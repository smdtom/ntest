package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StatisticCalculationServiceImplTest
{
    private StatisticCalculationServiceImpl statisticCalculationService;

    @Before
    public void setUp()
    {
        this.statisticCalculationService = new StatisticCalculationServiceImpl();
    }

    @Test
    public void calculateSum_should_return_zero()
    {
        double sum = statisticCalculationService.calculateSum(new ConcurrentHashMap<>());
        
        assertEquals(0, sum, 0);
    }

    @Test
    public void calculateSum_should_return_expected_result()
    {
        List<Double> amounts = new ArrayList<>();
        amounts.add(10.0);
        amounts.add(15.0);

        ConcurrentHashMap<Long, Transaction> transactions = TransactionMapHelper.createMap(amounts);
        double sum = statisticCalculationService.calculateSum(transactions);

        assertEquals(25.0, sum, 0);
    }

    @Test
    public void calculateAverage_should_return_zero()
    {
        double avg = statisticCalculationService.calculateSum(new ConcurrentHashMap<>());

        assertEquals(0, avg, 0);
    }

    @Test
    public void calculateAverage_should_return_expected_result()
    {
        List<Double> amounts = new ArrayList<>();
        amounts.add(5.0);
        amounts.add(15.0);

        ConcurrentHashMap<Long, Transaction> transaction = TransactionMapHelper.createMap(amounts);
        double avg = statisticCalculationService.calculateAverage(transaction);

        assertEquals(10.0, avg, 0);
    }

    @Test
    public void calculateMax_should_return_zero()
    {
        double max = statisticCalculationService.calculateSum(new ConcurrentHashMap<>());

        assertEquals(0, max, 0);
    }

    @Test
    public void calculateMax_should_return_expected_result()
    {
        List<Double> amounts = new ArrayList<>();
        amounts.add(5.0);
        amounts.add(15.0);

        ConcurrentHashMap<Long, Transaction> transaction = TransactionMapHelper.createMap(amounts);
        double avg = statisticCalculationService.calculateMax(transaction);

        assertEquals(15.0, avg, 0);
    }


    @Test
    public void calculateMin_should_return_zero()
    {
        double min = statisticCalculationService.calculateSum(new ConcurrentHashMap<>());

        assertEquals(0, min, 0);
    }

    @Test
    public void calculateMin_should_return_expected_result()
    {
        List<Double> amounts = new ArrayList<>();
        amounts.add(5.0);
        amounts.add(15.0);

        ConcurrentHashMap<Long, Transaction> transaction = TransactionMapHelper.createMap(amounts);
        double avg = statisticCalculationService.calculateMin(transaction);

        assertEquals(5.0, avg, 0);
    }
}
