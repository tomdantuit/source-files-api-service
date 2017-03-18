package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import com.e451.models.HouseholdDemographicRecord;
import com.e451.repository.HouseholdDemographicRepository;
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

public class HouseholdDemographicServiceTest {

    private final Long HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_1 = new Long(208);
    private final String HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_1 = "45-54";
    private final String HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_1 = "U";
    private final String HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_1 = "50-74K";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_1 = "Homeowner";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_1 = "2 Adults No Kids";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_1 = "2";
    private final String HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_1 = "None/Unknown";

    private final Long HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_2 = new Long(209);
    private final String HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_2 = "55-64";
    private final String HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_2 = "M";
    private final String HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_2 = "100-149K";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_2 = "Probable Homeowner";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_2 = "1 Adult 2 Kids";
    private final String HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_2 = "3";
    private final String HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_2 = "2 Kids";

    private HouseholdDemographicService testHouseholdDemographicService;
    private Pageable mockPageable = mock(Pageable.class);
    private HouseholdDemographicRepository HouseholdDemographicRepository = mock(HouseholdDemographicRepository.class);
    private List<HouseholdDemographicRecord> HouseholdDemographicRecords = new ArrayList<>(2);


    @Before
    public void setUp() {
        testHouseholdDemographicService = new HouseholdDemographicServiceImpl(HouseholdDemographicRepository);
    }

    @Test
    public void testHouseholdDemographicServiceShouldConstruct() {
        Assert.assertNotNull("Household demographic service didn't start"
                , testHouseholdDemographicService);
    }

    @Test
    public void setTestHouseholdDemographicServiceShouldReturnHouseholdDemographics() {
        HouseholdDemographicRecords.add(new HouseholdDemographicRecord(
                HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_1
                , HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_1
                , HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_1)
        );

        when(HouseholdDemographicRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(HouseholdDemographicRecords));
        Page<HouseholdDemographic> HouseholdDemographics = testHouseholdDemographicService.getHouseholdDemographics(mockPageable);
        Assert.assertNotNull("getHouseholdDemographics returned null", HouseholdDemographics);
        Assert.assertNotNull("Household Demographic body does not exist"
                , HouseholdDemographics.getContent());
    }

    @Test
    public void testHouseholdDemographicServiceShouldReturnTwoHouseholdDemographics() {
        HouseholdDemographicRecords.add(new HouseholdDemographicRecord(
                HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_1
                , HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_1
                , HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_1
        ));
        HouseholdDemographicRecords.add(new HouseholdDemographicRecord(
                HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_2
                , HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_2
                , HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_2
                , HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_2
                , HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_2
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_2
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_2
                , HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_2
        ));
        when(HouseholdDemographicRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(HouseholdDemographicRecords));
        Page<HouseholdDemographic> HouseholdDemographics = testHouseholdDemographicService.getHouseholdDemographics(mockPageable);
        Assert.assertNotNull("getHouseholdDemographics returned null", HouseholdDemographics);
        Assert.assertNotNull("Household Demographic body does not exist"
                , HouseholdDemographics.getContent());
        Assert.assertEquals("not the correct number of CampaignMemberships"
                , 2
                , HouseholdDemographics.getContent().size());
    }

    @Test
    public void testHouseholdDemographicServiceHouseholdDemographicRecordHouseholdDemographicConverterProperlyMapsHouseholdDemographic() {
        Converter<HouseholdDemographicRecord, HouseholdDemographic> testHouseholdDemographicRecordHouseholdDemographicConverter
                = testHouseholdDemographicService.getHouseholdDemographicRecordHouseholdDemographicConverter();

        Assert.assertNotNull(testHouseholdDemographicRecordHouseholdDemographicConverter);

        HouseholdDemographicRecord mockHouseholdDemographicRecord = new HouseholdDemographicRecord(
                HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_1
                , HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_1
                , HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_1
                , HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_1
        );

        HouseholdDemographic HouseholdDemographic = testHouseholdDemographicRecordHouseholdDemographicConverter.convert(mockHouseholdDemographicRecord);

        Assert.assertEquals("The HouseholdKey was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_KEY_1
                , HouseholdDemographic.getHshdKey());
        Assert.assertEquals("The AgeDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_AGE_DESC_1
                , HouseholdDemographic.getAgeDescription());
        Assert.assertEquals("The MaritalStatusCode was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_MARITAL_STATUS_CODE_1
                , HouseholdDemographic.getMaritalStatusCode());
        Assert.assertEquals("The IncomeDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_INCOME_DESC_1
                , HouseholdDemographic.getIncomeDesc());
        Assert.assertEquals("The AgeDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_HOMEOWNER_DESC_1
                , HouseholdDemographic.getHomeownerDesc());
        Assert.assertEquals("The HouseholdCompositionDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_COMP_DESC_1
                , HouseholdDemographic.getHouseholdCompositionDesc());
        Assert.assertEquals("The HouseholdSizeDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_HOUSEHOLD_SIZE_DESC_1
                , HouseholdDemographic.getHouseholdSizeDesc());
        Assert.assertEquals("The KidCategoryDescription was incorrectly converted"
                , HOUSEHOLD_DEMOGRAPHIC_KID_CATEGORY_DESC_1
                , HouseholdDemographic.getKidCategoryDesc());
    }
}
