package com.ntest.challenge.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistic
{
    private double sum = 0;

    private double avg = 0;

    private double max = 0;

    private double min = 0;

    private long count = 0;
}
