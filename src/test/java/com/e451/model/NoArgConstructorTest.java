package com.e451.model;

import org.junit.Assert;
import org.junit.Test;

public class NoArgConstructorTest {

    @Test
    public void testCampaignMembershipRecordModelHasNoArgConstructor() {
        CampaignMembershipRecord campaignMembershipRecord = new CampaignMembershipRecord();
        Assert.assertNotNull("CampaignMembership record was not constructed", campaignMembershipRecord);

        CouponRecord couponRecord = new CouponRecord();
        Assert.assertNotNull("Coupon record was not constructed", couponRecord);

    }
}
