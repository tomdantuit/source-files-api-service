package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import com.e451.repository.HouseholdDemographicRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static org.mockito.Mockito.mock;

/**
 * Created by k200745 on 2/23/2017.
 */
public class HouseholdDemographicTest {

    private HouseholdDemographicService testHouseholdDemographicService;
    private HouseholdDemographicRepository householdDemographicRepository = mock(HouseholdDemographicRepository.class);

    private Pageable mockPageable = mock(Pageable.class);

    @Before
    public void setUp() {
        testHouseholdDemographicService = new HouseholdDemographicServiceImpl(householdDemographicRepository);
    }

    @Test
    public void testHouseholdDemographicServiceShouldConstruct() {
        Assert.assertNotNull("Household demographic service didn't start"
                , testHouseholdDemographicService);
    }

    @Test
    public void testHouseholdDemographicServiceShouldReturnHouseholdDemographics() {
        Page<HouseholdDemographic> HouseholdDemographics = testHouseholdDemographicService.getHouseholdDemographics(mockPageable);
        Assert.assertNotNull("getHousehold returned null", HouseholdDemographics);
        Assert.assertNotNull("Household Demographics body does not exist"
                , HouseholdDemographics.getContent());

    }

}
