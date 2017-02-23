package com.e451.service;

import com.e451.domain.Coupon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;

public class CouponServiceTest {

    private CouponService testCouponService;
    private Pageable mockPageable = mock(Pageable.class);

    @Before
    public void setUp() {
        testCouponService = new CouponServiceImpl();

    }

    @Test
    public void testCouponServiceShouldConstruct() {
        Assert.assertNotNull("Coupon service didn't start"
                , testCouponService);
    }

    @Test
    public void testCouponServiceShouldReturnCoupons() {
        Page<Coupon> coupons = testCouponService.getCoupons(mockPageable);
        Assert.assertNotNull("getCoupons returned null", coupons);
        Assert.assertNotNull("coupons body does not exist"
                , coupons.getContent());

    }
}
