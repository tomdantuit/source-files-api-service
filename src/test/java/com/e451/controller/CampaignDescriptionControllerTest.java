package com.e451.controller;

import com.e451.domain.CampaignDescription;
import com.e451.service.CampaignDescriptionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class CampaignDescriptionControllerTest {

    private CampaignDescriptionController testCampaignDescriptionController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<CampaignDescription> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private CampaignDescriptionService mockCampaignDescriptionService = mock(CampaignDescriptionService.class);


    @Before
    public void setUp() {
        testCampaignDescriptionController = new CampaignDescriptionController(mockCampaignDescriptionService);
    }

    @Test
    public void testCampaignDescriptionControllerShouldConstruct() {
        Assert.assertNotNull("CampaignDescription controller failed to be initialized"
            , testCampaignDescriptionController);
    }

    @Test
    public void testCampaignDescriptionControllerShouldReturnAPageOfCampaignDescriptionObjects() {

        Assert.assertNotNull("CampaignDescription Controller did not return a page of CampaignDescription objects",
                testCampaignDescriptionController.getCampaignDescriptions(mockPageable, mockPagedResourcesAsssembler));

    }
}
