package com.e451.controller;


import com.e451.domain.Coupon;
import com.e451.service.CouponService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class CouponControllerTest {

    private CouponController testCouponController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<Coupon> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private CouponService mockCouponService = mock(CouponService.class);


    @Before
    public void setUp() {
        testCouponController = new CouponController(mockCouponService);
    }

    @Test
    public void testCouponControllerIsWorking() {
        Assert.assertNotNull("Coupon controller failed to start"
                , testCouponController);
    }

    @Test
    public void testCouponControllerReturnsObjects() {

        Assert.assertNotNull("Coupon Controller didn't return coupon objects",
                testCouponController.getCoupons(mockPageable, mockPagedResourcesAsssembler));

    }
}
