package com.e451.controller;

import com.e451.domain.Transaction;
import com.e451.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by e978726 on 2/27/2017.
 */
public class TransactionController {

    private TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService TransactionService) {
        this.transactionService = TransactionService;
    }

    @RequestMapping(path = "/transaction", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<Transaction>> getTransactions(Pageable pageable
            , PagedResourcesAssembler<Transaction> pageResourceAssembler) {
        Page<Transaction> transactions = transactionService.getTransactions(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(transactions),
                HttpStatus.OK);
    }
}
