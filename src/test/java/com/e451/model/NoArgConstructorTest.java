package com.e451.model;

import com.e451.models.CampaignMembershipRecord;
import org.junit.Assert;
import org.junit.Test;

public class NoArgConstructorTest {

    @Test
    public void testCampaignMembershipRecordModelHasNoArgConstructor() {
        CampaignMembershipRecord campaignMembershipRecord = new CampaignMembershipRecord();
        Assert.assertNotNull("CampaignMembership record was not constructed", campaignMembershipRecord);
    }
}
