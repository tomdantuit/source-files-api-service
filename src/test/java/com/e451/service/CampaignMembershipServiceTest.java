package com.e451.service;

import com.e451.domain.CampaignMembership;
import com.e451.models.CampaignMembershipRecord;
import com.e451.repository.CampaignMembershipRepository;
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

public class CampaignMembershipServiceTest {

    // Constants for testing
    private final Long CAMPAIGN_MEMBERSHIP_ID1 = new Long(1);
    private final Long CAMPAIGN_MEMBERSHIP1_HSHD_KEY = new Long(1);
    private final String CAMPAIGN_MEMBERSHIP1_DESC = "CampaignMembership1";

    private final Long CAMPAIGN_MEMBERSHIP2_ID = new Long(2);
    private final Long CAMPAIGN_MEMBERSHIP2_HSHD_KEY = new Long(2);
    private final String CAMPAIGN_MEMBERSHIP2_DESC = "CampaignMembership2";


    private CampaignMembershipService testCampaignMembershipService;
    private Pageable mockPageable = mock(Pageable.class);
    private CampaignMembershipRepository CampaignMembershipRepository = mock(CampaignMembershipRepository.class);
    private List<CampaignMembershipRecord> CampaignMembershipRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testCampaignMembershipService = new CampaignMembershipServiceImpl(CampaignMembershipRepository);

    }

    @Test
    public void testCampaignMembershipServiceShouldConstruct() {
        Assert.assertNotNull("CampaignMembership service was not instantiated"
                , testCampaignMembershipService);
    }

    @Test
    public void testCampaignMembershipServiceShouldReturnCampaignMemberships() {
        CampaignMembershipRecords.add(new CampaignMembershipRecord(CAMPAIGN_MEMBERSHIP_ID1
                , CAMPAIGN_MEMBERSHIP1_HSHD_KEY
                , CAMPAIGN_MEMBERSHIP1_DESC));
        when(CampaignMembershipRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CampaignMembershipRecords));
        Page<CampaignMembership> CampaignMemberships = testCampaignMembershipService.getCampaignMemberships(mockPageable);
        Assert.assertNotNull("getCampaignMemberships returned null", CampaignMemberships);
        Assert.assertNotNull("CampaignMemberships body does not exist"
                , CampaignMemberships.getContent());

    }

    @Test
    public void testCampaignMembershipServiceShouldReturnTwoCampaignMemberships() {
        CampaignMembershipRecords.add(new CampaignMembershipRecord(CAMPAIGN_MEMBERSHIP_ID1
                , CAMPAIGN_MEMBERSHIP1_HSHD_KEY
                , CAMPAIGN_MEMBERSHIP1_DESC));
        CampaignMembershipRecords.add(new CampaignMembershipRecord(CAMPAIGN_MEMBERSHIP2_ID
                , CAMPAIGN_MEMBERSHIP2_HSHD_KEY
                , CAMPAIGN_MEMBERSHIP2_DESC));
        when(CampaignMembershipRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CampaignMembershipRecords));
        Page<CampaignMembership> CampaignMemberships = testCampaignMembershipService.getCampaignMemberships(mockPageable);
        Assert.assertNotNull("getCampaignMemberships returned null", CampaignMemberships);
        Assert.assertNotNull("CampaignMemberships body does not exist"
                , CampaignMemberships.getContent());
        Assert.assertEquals("not the correct number of CampaignMemberships"
            , 2
            , CampaignMemberships.getContent().size());
    }

    @Test
    public void testCampaignMembershipServiceCampaignMembershipRecordCampaignMembershipConverterProperlyMapsCampaignMembership() {
        Converter<CampaignMembershipRecord, CampaignMembership> testCampaignMembershipRecordCampaignMembershipConverter
                = testCampaignMembershipService.getCampaignMembershipRecordCampaignMembershipConverter();

        Assert.assertNotNull(testCampaignMembershipRecordCampaignMembershipConverter);

        CampaignMembershipRecord mockCampaignMembershipRecord = new CampaignMembershipRecord(CAMPAIGN_MEMBERSHIP_ID1
            , CAMPAIGN_MEMBERSHIP1_HSHD_KEY
            , CAMPAIGN_MEMBERSHIP1_DESC);

        CampaignMembership CampaignMembership = testCampaignMembershipRecordCampaignMembershipConverter.convert(mockCampaignMembershipRecord);

        Assert.assertEquals("The ID was incorrectly converted", CAMPAIGN_MEMBERSHIP_ID1, CampaignMembership.getId());
        Assert.assertEquals("The HSHD_KEY was incorrectly converted"
                , CAMPAIGN_MEMBERSHIP1_HSHD_KEY
                , CampaignMembership.getHshdKey());
        Assert.assertEquals("The Description was incorrectly converted"
                , CAMPAIGN_MEMBERSHIP1_DESC
                , CampaignMembership.getDescription());
    }



}
