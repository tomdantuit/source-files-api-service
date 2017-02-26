package com.e451.controller;

import com.e451.domain.CouponRedemption;
import com.e451.service.CouponRedemptionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class CouponRedemptionControllerTest {

    private CouponRedemptionController testCouponRedemptionController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<CouponRedemption> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private CouponRedemptionService mockCouponRedemptionService = mock(CouponRedemptionService.class);

    @Before
    public void setUp() {
        testCouponRedemptionController = new CouponRedemptionController(mockCouponRedemptionService);
    }

    @Test
    public void testCouponRedemptionControllerIsWorking() {
        Assert.assertNotNull("Coupon redemption controller failed to start"
                , testCouponRedemptionController);
    }

    @Test
    public void setTestCouponRedemptionControllerReturnsObjects() {

        Assert.assertNotNull("Coupon redemption controller didn't return coupon redemption objects",
                testCouponRedemptionController.getCouponRedemptions(mockPageable, mockPagedResourcesAsssembler));

    }
}
