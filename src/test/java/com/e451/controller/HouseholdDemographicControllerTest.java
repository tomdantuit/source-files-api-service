package com.e451.controller;

import com.e451.domain.HouseholdDemographic;
import com.e451.service.HouseholdDemographicService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;

import static org.mockito.Mockito.mock;

/**
 * Created by k200745 on 3/9/2017.
 */
public class HouseholdDemographicControllerTest {

    private HouseholdDemographicController testHouseholdDemographicController;
    private Pageable mockPageable = mock(Pageable.class);
    private PagedResourcesAssembler<HouseholdDemographic> mockPagedResourcesAsssembler
            = mock(PagedResourcesAssembler.class);
    private HouseholdDemographicService mockHouseholdDemographicService = mock(HouseholdDemographicService.class);

    @Before
    public void setUp() {
        testHouseholdDemographicController = new HouseholdDemographicController(mockHouseholdDemographicService);
    }

    @Test
    public void testHouseholdDemographicControllerShouldConstruct() {
        Assert.assertNotNull("HouseholdDemographic controller failed to be initialized"
                , testHouseholdDemographicController);
    }

    @Test
    public void testHouseholdDemopgraphicControllerShouldReturnAPageOfHouseholdDemopgraphicObjects() {
        Assert.assertNotNull("HouseholdDemographic Controller did not return a page of CampaignMembership objects",
                testHouseholdDemographicController.getHouseholdDemographics(mockPageable, mockPagedResourcesAsssembler));
    }


}
