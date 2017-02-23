package com.e451.controller;

import com.e451.domain.Campaign;
import com.e451.service.CampaignService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class CampaignControllerTest {

    private CampaignController testCampaignController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<Campaign> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private CampaignService mockCampaignService = mock(CampaignService.class);


    @Before
    public void setUp() {
        testCampaignController = new CampaignController(mockCampaignService);
    }

    @Test
    public void testCampaignControllerShouldConstruct() {
        Assert.assertNotNull("Campaign controller failed to be initialized"
            , testCampaignController);
    }

    @Test
    public void testCampaignControllerShouldReturnAPageOfCampaignObjects() {

        Assert.assertNotNull("Campaign Controller did not return a page of campaign objects",
                testCampaignController.getCampaigns(mockPageable, mockPagedResourcesAsssembler));

    }
}
