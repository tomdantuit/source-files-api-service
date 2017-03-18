package com.e451.service;

import com.e451.domain.Transaction;
import com.e451.model.TransactionRecord;
import com.e451.repository.TransactionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionServiceTest {
    // Constants for testing
    private final Long ID = new Long(1);
    private final Long HOUSEHOLD_KEY = new Long(1);
    private final Long BASKET_ID = new Long(2);
    private final Long DAY = new Long(8);
    private final Long PRODUCT_ID = new Long(3);
    private final Long QUANTITY = new Long(4);
    private final Double SALES_VALUE = 1.25;
    private final Long STORE_ID = new Long(5);
    private final Double COUPON_MATCH_DISCOUNT = .55;
    private final Double COUPON_DISC = .10;
    private final Double RETAIL_DISC = .05;
    private final Long TRANS_TIME = new Long(1425);
    private final Long WEEK_NO = new Long(6);

    private final Long ID2 = new Long(2);
    private final Long HOUSEHOLD_KEY2 = new Long(2);
    private final Long BASKET_ID2 = new Long(3);
    private final Long DAY2 = new Long(8);
    private final Long PRODUCT_ID2 = new Long(4);
    private final Long QUANTITY2 = new Long(5);
    private final Double SALES_VALUE2 = 5.25;
    private final Long STORE_ID2 = new Long(6);
    private final Double COUPON_MATCH_DISCOUNT2 = .25;
    private final Double COUPON_DISC2 = .15;
    private final Double RETAIL_DISC2 = .07;
    private final Long TRANS_TIME2 = new Long(1725);
    private final Long WEEK_NO2 = new Long(7);

    private TransactionService testTransactionService;
    private Pageable mockPageable = mock(Pageable.class);
    private TransactionRepository mockTransactionRepository = mock(TransactionRepository.class);
    private List<TransactionRecord> transactionRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testTransactionService = new TransactionServiceImpl(mockTransactionRepository);
    }

    @Test
    public void testTransactionServiceShouldConstruct() {
        Assert.assertNotNull("Transaction service was not instantiated", testTransactionService);
    }

    @Test
    public void testTransactionServiceShouldReturnTransactions() {
        transactionRecords.add(new TransactionRecord(
                ID,
                HOUSEHOLD_KEY,
                BASKET_ID,
                DAY,
                PRODUCT_ID,
                QUANTITY,
                SALES_VALUE,
                STORE_ID,
                COUPON_MATCH_DISCOUNT,
                COUPON_DISC,
                RETAIL_DISC,
                TRANS_TIME,
                WEEK_NO));

        when(mockTransactionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(transactionRecords));
        Page<Transaction> transactions = testTransactionService.getTransactions(mockPageable);
        Assert.assertNotNull("getTransactions returned null", transactions);
        Assert.assertNotNull("Transactions body does not exist", transactions.getContent());
    }

    @Test
    public void testTransactionServiceShouldReturnTwoTransactions() {
        transactionRecords.add(new TransactionRecord(
                ID,
                HOUSEHOLD_KEY,
                BASKET_ID,
                DAY,
                PRODUCT_ID,
                QUANTITY,
                SALES_VALUE,
                STORE_ID,
                COUPON_MATCH_DISCOUNT,
                COUPON_DISC,
                RETAIL_DISC,
                TRANS_TIME,
                WEEK_NO));

        transactionRecords.add(new TransactionRecord(
                ID2,
                HOUSEHOLD_KEY2,
                BASKET_ID2,
                DAY2,
                PRODUCT_ID2,
                QUANTITY2,
                SALES_VALUE2,
                STORE_ID2,
                COUPON_MATCH_DISCOUNT2,
                COUPON_DISC2,
                RETAIL_DISC2,
                TRANS_TIME2,
                WEEK_NO2));

        when(mockTransactionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(transactionRecords));
        Page<Transaction> transactions = testTransactionService.getTransactions(mockPageable);
        Assert.assertNotNull("getTransactions returned null", transactions);
        Assert.assertNotNull("Transactions body does not exist", transactions.getContent());
        Assert.assertEquals("not the correct number of Transactions", 2, transactions.getContent().size());
    }

    @Test
    public void testTransactionServiceTransactionRecordTransactionConverterProperlyMapsTransaction() {
        Converter<TransactionRecord, Transaction> testTransactionRecordTransactionConverter
                = testTransactionService.getTransactionRecordTransactionConverter();

        Assert.assertNotNull(testTransactionRecordTransactionConverter);

        TransactionRecord mockTransactionRecord = new TransactionRecord(
                ID,
                HOUSEHOLD_KEY,
                BASKET_ID,
                DAY,
                PRODUCT_ID,
                QUANTITY,
                SALES_VALUE,
                STORE_ID,
                COUPON_MATCH_DISCOUNT,
                COUPON_DISC,
                RETAIL_DISC,
                TRANS_TIME,
                WEEK_NO);

        Transaction transaction = testTransactionRecordTransactionConverter.convert(mockTransactionRecord);

        Assert.assertEquals("The Id was incorrectly converted", ID, transaction.getId());
        Assert.assertEquals("The basketId was incorrectly converted", BASKET_ID, transaction.getBasketId());
        Assert.assertEquals("The householdKey was incorrectly converted" , HOUSEHOLD_KEY, transaction.getHouseholdKey());
        Assert.assertEquals("The coupon discount was incorrectly converted", COUPON_DISC, transaction.getCouponDisc(), 0);
        Assert.assertEquals("The day was incorrectly converted", DAY, transaction.getDay());
        Assert.assertEquals("The productId was incorrectly converted", PRODUCT_ID, transaction.getProductId());
        Assert.assertEquals("The quantity was incorrectly converted", QUANTITY, transaction.getQuantity());
        Assert.assertEquals("The salesValue was incorrectly converted", SALES_VALUE, transaction.getSalesValue(), 0);
        Assert.assertEquals("The storeId was incorrectly converted", STORE_ID, transaction.getStoreId());
        Assert.assertEquals("The couponMatchDiscount was incorrectly converted", COUPON_MATCH_DISCOUNT, transaction.getCouponMatchDiscount(), 0);
        Assert.assertEquals("The retailDsic was incorrectly converted", RETAIL_DISC, transaction.getRetailDisc(), 0);
        Assert.assertEquals("The transTime was incorrectly converted", TRANS_TIME, transaction.getTransTime());
        Assert.assertEquals("The weekNo was incorrectly converted", WEEK_NO, transaction.getWeekNo());
    }

}
