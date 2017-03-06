package com.e451.service;

import com.e451.domain.Coupon;
import com.e451.model.CouponRecord;
import com.e451.repository.CouponRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CouponServiceTest {

    private static final long COUPON_CAMPAIGN_1 = 1;
    private static final long COUPON_UPC_1 = 123456789;
    private static final long COUPON_PROD_1 = 1;
    private static final long COUPON_RECORD_1_ID = 1;
    private static final long COUPON_CAMPAIGN_2 = 2;
    private static final long COUPON_UPC_2 = 234567891;
    private static final long COUPON_PROD_2 = 1;
    private static final long COUPON_RECORD_2_ID = 2;
    private CouponServiceImpl testCouponService;
    private Pageable mockPageable = mock(Pageable.class);
    private List<CouponRecord> couponRecords = new ArrayList<>(2);
    private CouponRepository mockCouponRepository = mock(CouponRepository.class);

    @Before
    public void setUp() {
        testCouponService = new CouponServiceImpl(mockCouponRepository);

    }

    @Test
    public void testCouponServiceShouldConstruct() {
        Assert.assertNotNull("Coupon service didn't start"
                , testCouponService);
    }

    @Test
    public void testCouponServiceShouldReturnCoupons() {
        couponRecords.add(new CouponRecord(COUPON_CAMPAIGN_1, COUPON_UPC_1, COUPON_PROD_1, COUPON_RECORD_1_ID));

        when(mockCouponRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(couponRecords));
        Page<Coupon> coupons = testCouponService.getCoupons(mockPageable);
        Assert.assertNotNull("getCoupons returned null", coupons);
        Assert.assertNotNull("Coupons body does not exist"
                , coupons.getContent());

        Coupon coupon = coupons.getContent().get(0);
        Assert.assertEquals("Coupon campaign is incorrect", COUPON_CAMPAIGN_1, coupon.getCampaign());
        Assert.assertEquals("Coupon upc is incorrect", COUPON_UPC_1, coupon.getCouponUpc());
        Assert.assertEquals("Coupon product id is incorrect", COUPON_PROD_1, coupon.getProdId());
    }

    @Test
    public void testCouponServiceShouldReturnTwoCoupons() {
        couponRecords.add(new CouponRecord(COUPON_CAMPAIGN_1
                , COUPON_UPC_1
                , COUPON_PROD_1
                , COUPON_RECORD_1_ID));
        couponRecords.add(new CouponRecord(COUPON_CAMPAIGN_2
                , COUPON_UPC_2
                , COUPON_PROD_2
                , COUPON_RECORD_2_ID));
        when(mockCouponRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(couponRecords));
        Page<Coupon> coupons = testCouponService.getCoupons(mockPageable);
        Assert.assertNotNull("getCoupons returned null", coupons);
        Assert.assertNotNull("Coupons body does not exist"
                , coupons.getContent());
        Assert.assertEquals("not the correct number of Coupons"
                , 2
                , coupons.getContent().size());
    }

    @Test
    public void testCouponRecordCouponConverterConvertsCorrectly() {
        CouponRecord couponRecord = new CouponRecord(COUPON_CAMPAIGN_1
            , COUPON_UPC_1
            , COUPON_PROD_1
            , COUPON_RECORD_1_ID);

        Coupon coupon = testCouponService.getCouponRecordCouponConverter().convert(couponRecord);

        Assert.assertEquals("Coupon campaign not converted properly", COUPON_CAMPAIGN_1, coupon.getCampaign());
        Assert.assertEquals("Coupon upc not converted properly", COUPON_UPC_1, coupon.getCouponUpc());
        Assert.assertEquals("Coupon product id not converted properly", COUPON_PROD_1, coupon.getProdId());
    }
}
