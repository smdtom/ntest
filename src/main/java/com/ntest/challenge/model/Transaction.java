package com.ntest.challenge.model;

import javax.validation.constraints.NotNull;

public class Transaction
{
    @NotNull
    public double amount;

    @NotNull
    public long timestamp;

    @Override
    public String toString() {
        return "amount:" + amount + ", timestamp:" + timestamp;
    }
}
