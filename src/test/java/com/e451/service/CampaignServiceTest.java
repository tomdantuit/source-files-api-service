package com.e451.service;

import com.e451.domain.Campaign;
import com.e451.models.CampaignRecord;
import com.e451.repository.CampaignRepository;
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

public class CampaignServiceTest {

    // Constants for testing
    private final Long CAMPAIGN1_ID = new Long(1);
    private final Long CAMPAIGN1_HSHD_KEY = new Long(1);
    private final String CAMPAIGN1_DESC = "CAMPAIGN1";

    private final Long CAMPAIGN2_ID = new Long(2);
    private final Long CAMPAIGN2_HSHD_KEY = new Long(2);
    private final String CAMPAIGN2_DESC = "CAMPAIGN2";


    private CampaignService testCampaignService;
    private Pageable mockPageable = mock(Pageable.class);
    private CampaignRepository campaignRepository = mock(CampaignRepository.class);
    private List<CampaignRecord> campaignRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testCampaignService = new CampaignServiceImpl(campaignRepository);

    }

    @Test
    public void testCampaignServiceShouldConstruct() {
        Assert.assertNotNull("Campaign service was not instantiated"
                , testCampaignService);
    }

    @Test
    public void testCampaignServiceShouldReturnCampaigns() {
        campaignRecords.add(new CampaignRecord(CAMPAIGN1_ID
                , CAMPAIGN1_HSHD_KEY
                , CAMPAIGN1_DESC));
        when(campaignRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<CampaignRecord>(campaignRecords));
        Page<Campaign> campaigns = testCampaignService.getCampaigns(mockPageable);
        Assert.assertNotNull("getCampaigns returned null", campaigns);
        Assert.assertNotNull("campaigns body does not exist"
                , campaigns.getContent());

    }

    @Test
    public void testCampaignServiceShouldReturnTwoCampaigns() {
        campaignRecords.add(new CampaignRecord(CAMPAIGN1_ID
                , CAMPAIGN1_HSHD_KEY
                , CAMPAIGN1_DESC));
        campaignRecords.add(new CampaignRecord(CAMPAIGN2_ID
                , CAMPAIGN2_HSHD_KEY
                , CAMPAIGN2_DESC));
        when(campaignRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<CampaignRecord>(campaignRecords));
        Page<Campaign> campaigns = testCampaignService.getCampaigns(mockPageable);
        Assert.assertNotNull("getCampaigns returned null", campaigns);
        Assert.assertNotNull("campaigns body does not exist"
                , campaigns.getContent());
        Assert.assertEquals("not the correct number of campaigns"
            , 2
            , campaigns.getContent().size());
    }

    @Test
    public void testCampaignServiceCampaignRecordCampaignConverterProperlyMapsCampaign() {
        Converter<CampaignRecord, Campaign> testCampaignRecordCampaignConverter
                = testCampaignService.getCampaignRecordCampaignConverter();

        Assert.assertNotNull(testCampaignRecordCampaignConverter);

        CampaignRecord mockCampaignRecord = new CampaignRecord(CAMPAIGN1_ID
            , CAMPAIGN1_HSHD_KEY
            , CAMPAIGN1_DESC);

        Campaign campaign = testCampaignRecordCampaignConverter.convert(mockCampaignRecord);

        Assert.assertEquals("The ID was incorrectly converted", CAMPAIGN1_ID, campaign.getId());
        Assert.assertEquals("The HSHD_KEY was incorrectly converted"
                , CAMPAIGN1_HSHD_KEY
                , campaign.getHshdKey());
        Assert.assertEquals("The Description was incorrectly converted"
                , CAMPAIGN1_DESC
                , campaign.getDescription());
    }



}
