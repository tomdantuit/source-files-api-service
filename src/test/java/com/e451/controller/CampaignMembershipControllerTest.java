package com.e451.controller;

import com.e451.domain.CampaignMembership;
import com.e451.service.CampaignMembershipService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

public class CampaignMembershipControllerTest {

    private CampaignMembershipController testCampaignMembershipController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<CampaignMembership> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private CampaignMembershipService mockCampaignMembershipService = mock(CampaignMembershipService.class);


    @Before
    public void setUp() {
        testCampaignMembershipController = new CampaignMembershipController(mockCampaignMembershipService);
    }

    @Test
    public void testCampaignMembershipControllerShouldConstruct() {
        Assert.assertNotNull("CampaignMembership controller failed to be initialized"
            , testCampaignMembershipController);
    }

    @Test
    public void testCampaignMembershipControllerShouldReturnAPageOfCampaignMembershipObjects() {

        Assert.assertNotNull("CampaignMembership Controller did not return a page of CampaignMembership objects",
                testCampaignMembershipController.getCampaignMemberships(mockPageable, mockPagedResourcesAsssembler));

    }
}
