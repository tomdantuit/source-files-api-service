package com.e451.service;

import com.e451.domain.Campaign;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;

public class CampaignServiceTest {

    private CampaignService testCampaignService;
    private Pageable mockPageable = mock(Pageable.class);

    @Before
    public void setUp() {
        testCampaignService = new CampaignServiceImpl();

    }

    @Test
    public void testCampaignServiceShouldConstruct() {
        Assert.assertNotNull("Campaign service was not instantiated"
                , testCampaignService);
    }

    @Test
    public void testCampaignServiceShouldReturnCampaigns() {
        Page<Campaign> campaigns = testCampaignService.getCampaigns(mockPageable);
        Assert.assertNotNull("getCampaigns returned null", campaigns);
        Assert.assertNotNull("campaigns body does not exist"
                , campaigns.getContent());

    }



}
