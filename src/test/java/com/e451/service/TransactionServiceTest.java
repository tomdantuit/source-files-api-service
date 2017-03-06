package com.e451.service;

import com.e451.domain.Transaction;
import com.e451.models.TransactionRecord;
import com.e451.repository.TransactionRepository;
import org.apache.catalina.Store;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by e978726 on 2/28/2017.
 */
public class TransactionServiceTest {
    // Constants for testing
    private final Long HOUSEHOLD_KEY = new Long(1);
    private final Long BASKET_ID = new Long(2);
    private final Long DAY = new Long(8);
    private final Long PRODUCT_ID = new Long(3);
    private final Long QUANTITY = new Long(4);
    private final double SALES_VALUE = 1.25;
    private final Long STORE_ID = new Long(5);
    private final double COUPON_MATCH_DISCOUNT = .55;
    private final double COUPON_DISC = .10;
    private final double RETAIL_DISC = .05;
    private final Date TRANS_TIME = new Date();
    private final Long WEEK_NO = new Long(6);

    private final Long HOUSEHOLD_KEY2 = new Long(2);
    private final Long BASKET_ID2 = new Long(3);
    private final Long DAY2 = new Long(8);
    private final Long PRODUCT_ID2 = new Long(4);
    private final Long QUANTITY2 = new Long(5);
    private final double SALES_VALUE2 = 5.25;
    private final Long STORE_ID2 = new Long(6);
    private final double COUPON_MATCH_DISCOUNT2 = .25;
    private final double COUPON_DISC2 = .15;
    private final double RETAIL_DISC2 = .07;
    private final Date TRANS_TIME2 = new Date();
    private final Long WEEK_NO2 = new Long(7);

    private TransactionService testTransactionService;
    private Pageable mockPageable = mock(Pageable.class);
    private TransactionRepository TransactionRepository = mock(TransactionRepository.class);
    private List<TransactionRecord> TransactionRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testTransactionService = new TransactionServiceImpl(TransactionRepository);

    }

    @Test
    public void testTransactionServiceShouldConstruct() {
        Assert.assertNotNull("Transaction service was not instantiated"
                , testTransactionService);
    }

    @Test
    public void testTransactionServiceShouldReturnTransactions() {
        TransactionRecords.add(new TransactionRecord(
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
                WEEK_NO
        ));
        when(TransactionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(TransactionRecords));
        Page<Transaction> Transactions = testTransactionService.getTransactions(mockPageable);
        Assert.assertNotNull("getTransactions returned null", Transactions);
        Assert.assertNotNull("Transactions body does not exist"
                , Transactions.getContent());

    }

    @Test
    public void testTransactionServiceShouldReturnTwoTransactions() {
        TransactionRecords.add(new TransactionRecord(HOUSEHOLD_KEY,
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
        TransactionRecords.add(new TransactionRecord(
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
                WEEK_NO2
        ));
        when(TransactionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(TransactionRecords));
        Page<Transaction> Transactions = testTransactionService.getTransactions(mockPageable);
        Assert.assertNotNull("getTransactions returned null", Transactions);
        Assert.assertNotNull("Transactions body does not exist"
                , Transactions.getContent());
        Assert.assertEquals("not the correct number of Transactions"
                , 2
                , Transactions.getContent().size());
    }

    @Test
    public void testTransactionServiceTransactionRecordTransactionConverterProperlyMapsTransaction() {
        Converter<TransactionRecord, Transaction> testTransactionRecordTransactionConverter
                = testTransactionService.getTransactionRecordTransactionConverter();

        Assert.assertNotNull(testTransactionRecordTransactionConverter);

        TransactionRecord mockTransactionRecord = new TransactionRecord(
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
                WEEK_NO
        );

        Transaction Transaction = testTransactionRecordTransactionConverter.convert(mockTransactionRecord);

        Assert.assertEquals("The basketId was incorrectly converted", BASKET_ID, Transaction.getBasketId());
        Assert.assertEquals("The householdKey was incorrectly converted" , HOUSEHOLD_KEY, Transaction.getHouseholdKey());
        Assert.assertEquals("The coupon discount was incorrectly converted", COUPON_DISC, Transaction.getCouponDisc(), 0);
        Assert.assertEquals("The day was incorrectly converted", DAY, Transaction.getDay());
        Assert.assertEquals("The productId was incorrectly converted", PRODUCT_ID, Transaction.getProductId());
        Assert.assertEquals("The quantity was incorrectly converted", QUANTITY, Transaction.getQuantity());
        Assert.assertEquals("The salesValue was incorrectly converted", SALES_VALUE, Transaction.getSalesValue(), 0);
        Assert.assertEquals("The storeId was incorrectly converted", STORE_ID, Transaction.getStoreId());
        Assert.assertEquals("The couponMatchDiscount was incorrectly converted", COUPON_MATCH_DISCOUNT, Transaction.getCouponMatchDiscount(), 0);
        Assert.assertEquals("The retailDsic was incorrectly converted", RETAIL_DISC, Transaction.getRetailDisc(), 0);
        Assert.assertEquals("The transTime was incorrectly converted", TRANS_TIME, Transaction.getTransTime());
        Assert.assertEquals("The weekNo was incorrectly converted", WEEK_NO, Transaction.getWeekNo());








    }

}
