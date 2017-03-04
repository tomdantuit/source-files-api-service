package com.e451.service;


import com.e451.domain.CouponRedemption;
import com.e451.model.CouponRedemptionRecord;
import com.e451.repository.CouponRedemptionRepository;
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

public class CouponRedemptionServiceTest {

    // Constants for testing
    private final Long COUPON_REDEMPTION_KEY_1 = new Long(1);
    private final String COUPON_REDEMPTION_DAY_1 = "12/1/2016";
    private final String COUPON_REDEMPTION_UPC_1 = "11111111";
    private final String COUPON_REDEMPTION_CAMPAIGN_1 = "Mega Event";

    private final Long COUPON_REDEMPTION_KEY_2 = new Long(2);
    private final String COUPON_REDEMPTION_DAY_2 = "10/1/2016";
    private final String COUPON_REDEMPTION_UPC_2 = "2222222";
    private final String COUPON_REDEMPTION_CAMPAIGN_2 = "LCM Event";

    private CouponRedemptionServiceImpl testCouponRedemptionService;
    private Pageable mockPageable = mock(Pageable.class);
    private CouponRedemptionRepository couponRedemptionRepository = mock(CouponRedemptionRepository.class);
    private List<CouponRedemptionRecord> couponRedemptionRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testCouponRedemptionService = new CouponRedemptionServiceImpl(couponRedemptionRepository);

    }

    @Test
    public void setTestCouponRedemptionServiceShouldConstruct() {
        Assert.assertNotNull("Coupon redemption service was not instantiated"
                , testCouponRedemptionService);
    }

    @Test
    public void testCouponRedemptionServiceShouldReturnCouponRedemptions() {
        couponRedemptionRecords.add(new CouponRedemptionRecord(COUPON_REDEMPTION_KEY_1
                , COUPON_REDEMPTION_CAMPAIGN_1
                ,COUPON_REDEMPTION_UPC_1
                , COUPON_REDEMPTION_DAY_1));
        when(couponRedemptionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(couponRedemptionRecords));
        Page<CouponRedemption> couponRedemptions = testCouponRedemptionService.getCouponRedemptions(mockPageable);
        Assert.assertNotNull("getCouponRedemptions returned null", couponRedemptions);
        Assert.assertNotNull("Coupon Redemptions body does not exist"
                , couponRedemptions.getContent());

    }

    @Test
    public void setTestCouponRedemptionServiceShouldReturnTwoCouponRedemptions() {
        couponRedemptionRecords.add(new CouponRedemptionRecord(COUPON_REDEMPTION_KEY_1
                , COUPON_REDEMPTION_CAMPAIGN_1
                ,COUPON_REDEMPTION_UPC_1
                , COUPON_REDEMPTION_DAY_1));
        couponRedemptionRecords.add(new CouponRedemptionRecord(COUPON_REDEMPTION_KEY_2
                , COUPON_REDEMPTION_CAMPAIGN_2
                ,COUPON_REDEMPTION_UPC_2
                , COUPON_REDEMPTION_DAY_2));
        when(couponRedemptionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(couponRedemptionRecords));
        Page<CouponRedemption> couponRedemptions = testCouponRedemptionService.getCouponRedemptions(mockPageable);
        Assert.assertNotNull("getCouponRedemptions returned null", couponRedemptions);
        Assert.assertNotNull("Coupon Redemptions body does not exist"
                , couponRedemptions.getContent());
        Assert.assertEquals("not the correct number of coupon redemptions"
                , 2
                , couponRedemptions.getContent().size());
    }

    @Test
    public void setTestCouponRedemptionServiceCouponRedemptionsRecordCouponRedemptionConverterProperlyMapsCouponRedemptions() {
        Converter<CouponRedemptionRecord, CouponRedemption> testCouponRedemptionRecordCouponRedemptionConverter
                = testCouponRedemptionService.getCouponRedemptionRecordCouponRedemptionConverter();

        Assert.assertNotNull(testCouponRedemptionRecordCouponRedemptionConverter);

        CouponRedemptionRecord mockCouponRedemptionRecord = new CouponRedemptionRecord(COUPON_REDEMPTION_KEY_1
                , COUPON_REDEMPTION_DAY_1
                , COUPON_REDEMPTION_UPC_1
                , COUPON_REDEMPTION_CAMPAIGN_1);

        CouponRedemption couponRedemption = testCouponRedemptionRecordCouponRedemptionConverter.convert(mockCouponRedemptionRecord);

        Assert.assertEquals("The Household Key was incorrectly converted", COUPON_REDEMPTION_KEY_1, couponRedemption.getHouseholdKey());
        Assert.assertEquals("The campaign was incorrectly converted"
                , COUPON_REDEMPTION_CAMPAIGN_1
                , couponRedemption.getCampaign());
        Assert.assertEquals("The UPC was incorrectly converted"
                , COUPON_REDEMPTION_UPC_1
                , couponRedemption.getCouponUpc());

    }

}
