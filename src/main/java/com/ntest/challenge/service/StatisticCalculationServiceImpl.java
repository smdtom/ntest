package com.ntest.challenge.service;

import com.ntest.challenge.model.Transaction;
import org.springframework.stereotype.Service;
import java.util.OptionalDouble;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StatisticCalculationServiceImpl implements StatisticCalculationService
{
    @Override
    public double calculateSum(ConcurrentHashMap<Long, Transaction> transactions) {
        return transactions.entrySet()
            .stream()
            .mapToDouble(a -> a.getValue().amount)
            .sum()
        ;
    }

    @Override
    public double calculateAverage(ConcurrentHashMap<Long, Transaction>transactions) {
        OptionalDouble average = transactions.entrySet()
            .stream()
            .mapToDouble(a -> a.getValue().amount)
            .average()
        ;

        return average.isPresent() ? average.getAsDouble() : 0;
    }

    @Override
    public double calculateMax(ConcurrentHashMap<Long, Transaction>transactions) {
        OptionalDouble max = transactions.entrySet()
            .stream()
            .mapToDouble(a -> a.getValue().amount)
            .max()
        ;

        return max.isPresent() ? max.getAsDouble() : 0;
    }

    @Override
    public double calculateMin(ConcurrentHashMap<Long, Transaction>transactions) {
        OptionalDouble min = transactions.entrySet()
            .stream()
            .mapToDouble(a -> a.getValue().amount)
            .min()
        ;

        return min.isPresent() ? min.getAsDouble() : 0;
    }
}
