package com.e451.service;


import com.e451.domain.Causal;
import com.e451.model.CausalRecord;
import com.e451.repository.CausalRepository;
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

public class CausalServiceTest {

    // Constants for testing
    private final Long CAUSAL1_ID = new Long(1);
    private final Long CAUSAL1_PRODUCT_ID = new Long(1);
    private final Long CAUSAL1_STORE_ID = new Long(1);
    private final int CAUSAL1_WEEK_NO = 1;
    private final String CAUSAL1_DISPLAY = "Display1";
    private final String CAUSAL1_MAILER = "Mailer1";

    private final Long CAUSAL2_ID = new Long(2);
    private final Long CAUSAL2_PRODUCT_ID = new Long(2);
    private final Long CAUSAL2_STORE_ID = new Long(2);
    private final int CAUSAL2_WEEK_NO = 2;
    private final String CAUSAL2_DISPLAY = "Display2";
    private final String CAUSAL2_MAILER = "Mailer2";

    private CausalServiceImpl testCausalService;
    private Pageable mockPageable = mock(Pageable.class);
    private CausalRepository CausalRepository = mock(CausalRepository.class);
    private List<CausalRecord> CausalRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testCausalService = new CausalServiceImpl(CausalRepository);
    }

    @Test
    public void testCausalServiceShouldConstruct() {
       Assert.assertNotNull("Causal service didn't start"
            , testCausalService);
    }

    @Test
    public void testCausalServiceShouldReturnCausals() {
        CausalRecords.add(new CausalRecord(CAUSAL1_ID
                , CAUSAL1_PRODUCT_ID
                , CAUSAL1_STORE_ID
                , CAUSAL1_WEEK_NO
                , CAUSAL1_DISPLAY
                , CAUSAL1_MAILER));
        when(CausalRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CausalRecords));
        Page<Causal> Causals = testCausalService.getCausals(mockPageable);
        Assert.assertNotNull("getCausals returned null", Causals);
        Assert.assertNotNull("Causals body does not exist", Causals.getContent());
    }

    @Test
    public void setTestCausalServiceShouldReturnTwoCausals() {
        CausalRecords.add(new CausalRecord(CAUSAL1_ID
                , CAUSAL1_PRODUCT_ID
                , CAUSAL1_STORE_ID
                , CAUSAL1_WEEK_NO
                , CAUSAL1_DISPLAY
                , CAUSAL1_MAILER));
        CausalRecords.add(new CausalRecord(CAUSAL2_ID
                , CAUSAL2_PRODUCT_ID
                , CAUSAL2_STORE_ID
                , CAUSAL2_WEEK_NO
                , CAUSAL2_DISPLAY
                , CAUSAL2_MAILER));
        when(CausalRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CausalRecords));
        Page<Causal> Causals = testCausalService.getCausals(mockPageable);
        Assert.assertNotNull("getCausals returned null", Causals);
        Assert.assertNotNull("Causals body does not exist", Causals.getContent());
        Assert.assertEquals("not the correct number of Causals", 2, Causals.getContent().size());
    }

    @Test
    public void testCausalServiceCausalRecordCausalConverterProperlyMapsCausal() {
        Converter<CausalRecord, Causal> testCausalRecordCausalConverter
                = testCausalService.getCausalRecordCausalConverter();

        Assert.assertNotNull(testCausalRecordCausalConverter);

        CausalRecord mockCausalRecord = new CausalRecord(CAUSAL1_ID
                , CAUSAL1_PRODUCT_ID
                , CAUSAL1_STORE_ID
                , CAUSAL1_WEEK_NO
                , CAUSAL1_DISPLAY
                , CAUSAL1_MAILER);

        Causal Causal = testCausalRecordCausalConverter.convert(mockCausalRecord);

        Assert.assertEquals("The ID was incorrectly converted", CAUSAL1_ID, Causal.getId());
        Assert.assertEquals("The product_id was incorrectly converted", CAUSAL1_PRODUCT_ID, Causal.getProductId());
        Assert.assertEquals("The store_id was incorrectly converted", CAUSAL1_STORE_ID, Causal.getStoreId());
        Assert.assertEquals("The week_no was incorrectly converted", CAUSAL1_WEEK_NO, Causal.getWeekNo());
        Assert.assertEquals("The display was incorrectly converted", CAUSAL1_DISPLAY, Causal.getDisplay());
        Assert.assertEquals("The mailer was incorrectly converted", CAUSAL1_MAILER, Causal.getMailer());
    }
}
