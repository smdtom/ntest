package com.ntest.challenge.controller;

import com.ntest.challenge.model.Statistic;
import com.ntest.challenge.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticController
{
    private StatisticService statisticService;

    @Autowired
    public StatisticController(final StatisticService statisticService)
    {
        this.statisticService = statisticService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Statistic> getStatistic()
    {
        return new ResponseEntity<>(statisticService.getStatistic(), HttpStatus.OK);
    }
}
