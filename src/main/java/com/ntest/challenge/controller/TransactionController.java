package com.ntest.challenge.controller;

import com.ntest.challenge.exception.OutdatedTransactionException;
import com.ntest.challenge.model.Transaction;
import com.ntest.challenge.service.TransactionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionController
{
    private static final Logger logger = LogManager.getLogger(TransactionController.class);

    private TransactionService transactionService;

    @Autowired
    public TransactionController(final TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void registerTransaction(@Valid @RequestBody Transaction transaction)
    {
       transactionService.register(transaction);
    }

    @ExceptionHandler(OutdatedTransactionException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleException(OutdatedTransactionException e) {
        logger.error(e);
    }
}
