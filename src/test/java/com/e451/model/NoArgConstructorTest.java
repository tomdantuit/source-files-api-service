package com.e451.model;

import com.e451.model.HouseholdDemographicRecord;
import org.junit.Assert;
import org.junit.Test;

public class NoArgConstructorTest {

    @Test
    public void testCampaignMembershipRecordModelHasNoArgConstructor() {
        CampaignMembershipRecord campaignMembershipRecord = new CampaignMembershipRecord();
        Assert.assertNotNull("CampaignMembership record was not constructed", campaignMembershipRecord);

        HouseholdDemographicRecord householdDemographicRecord = new HouseholdDemographicRecord();
        Assert.assertNotNull("HouseholdDemographic record was not constructed", householdDemographicRecord);

        CouponRecord couponRecord = new CouponRecord();
        Assert.assertNotNull("Coupon record was not constructed", couponRecord);

    }
}
