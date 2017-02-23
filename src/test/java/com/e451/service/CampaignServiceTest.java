package com.e451.service;

import com.e451.domain.Campaign;
import com.e451.models.CampaignRecord;
import com.e451.repository.CampaignRepository;
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

public class CampaignServiceTest {

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
        campaignRecords.add(new CampaignRecord(new Long(1)
                , new Long(1)
                ,  "desc1"));
        when(campaignRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<CampaignRecord>(campaignRecords));
        Page<Campaign> campaigns = testCampaignService.getCampaigns(mockPageable);
        Assert.assertNotNull("getCampaigns returned null", campaigns);
        Assert.assertNotNull("campaigns body does not exist"
                , campaigns.getContent());

    }

    @Test
    public void testCampaignServiceShouldReturnTwoCampaigns() {
        campaignRecords.add(new CampaignRecord(new Long(1)
                , new Long(1)
                ,  "desc1"));
        campaignRecords.add(new CampaignRecord(new Long(2)
                , new Long(2)
                ,  "desc2"));
        when(campaignRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<CampaignRecord>(campaignRecords));
        Page<Campaign> campaigns = testCampaignService.getCampaigns(mockPageable);
        Assert.assertNotNull("getCampaigns returned null", campaigns);
        Assert.assertNotNull("campaigns body does not exist"
                , campaigns.getContent());
        Assert.assertEquals("not the correct number of campaigns"
            , 2
            , campaigns.getContent().size());
    }



}
