package com.e451.controller;

import com.e451.domain.Transaction;
import com.e451.service.TransactionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class TransactionControllerTest {
    private TransactionController testTransactionController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<Transaction> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private TransactionService mockTransactionService = mock(TransactionService.class);


    @Before
    public void setUp() {
        testTransactionController = new TransactionController(mockTransactionService);
    }

    @Test
    public void testTransactionControllerShouldConstruct() {
        Assert.assertNotNull("Transaction controller failed to be initialized"
                , testTransactionController);
    }

    @Test
    public void testTransactionControllerShouldReturnAPageOfTransactionObjects() {

        Assert.assertNotNull("Transaction Controller did not return a page of Transaction objects",
                testTransactionController.getTransactions(mockPageable, mockPagedResourcesAsssembler));

    }
}
