package com.e451.service;

import com.e451.domain.CampaignDescription;
import com.e451.model.CampaignDescriptionRecord;
import com.e451.repository.CampaignDescriptionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CampaignDescriptionServiceTest {

    // Constants for testing
    private final Long CAMPAIGN_DESCRIPTION_CAMPAIGN1 = new Long(1);
    private final String CAMPAIGN_DESCRIPTION_DESCRIPTION1 = "CampaignDescription1";
    private final Long CAMPAIGN_DESCRIPTION_START_DAY1 = new Long(1);
    private final Long CAMPAIGN_DESCRIPTION_END_DAY1 = new Long(10);

    private final Long CAMPAIGN_DESCRIPTION_CAMPAIGN2 = new Long(2);
    private final String CAMPAIGN_DESCRIPTION_DESCRIPTION2 = "CampaignDescription2";
    private final Long CAMPAIGN_DESCRIPTION_START_DAY2 = new Long(2);
    private final Long CAMPAIGN_DESCRIPTION_END_DAY2 = new Long(20);


    private CampaignDescriptionServiceImpl testCampaignDescriptionService;
    private Pageable mockPageable = mock(Pageable.class);
    private CampaignDescriptionRepository CampaignDescriptionRepository = mock(CampaignDescriptionRepository.class);
    private List<CampaignDescriptionRecord> CampaignDescriptionRecords = new ArrayList<>(2);

    @Before
    public void setUp() {
        testCampaignDescriptionService = new CampaignDescriptionServiceImpl(CampaignDescriptionRepository);

    }

    @Test
    public void testCampaignDescriptionServiceShouldConstruct() {
        Assert.assertNotNull("CampaignDescription service was not instantiated"
                , testCampaignDescriptionService);
    }

    @Test
    public void testCampaignDescriptionServiceShouldReturnCampaignDescriptions() {
        CampaignDescriptionRecords.add(new CampaignDescriptionRecord(CAMPAIGN_DESCRIPTION_CAMPAIGN1
                , CAMPAIGN_DESCRIPTION_DESCRIPTION1
                , CAMPAIGN_DESCRIPTION_START_DAY1
                , CAMPAIGN_DESCRIPTION_END_DAY1));
        when(CampaignDescriptionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CampaignDescriptionRecords));
        Page<CampaignDescription> CampaignDescriptions = testCampaignDescriptionService.getCampaignDescriptions(mockPageable);
        Assert.assertNotNull("getCampaignDescriptions returned null", CampaignDescriptions);
        Assert.assertNotNull("CampaignDescriptions body does not exist"
                , CampaignDescriptions.getContent());

    }

    @Test
    public void testCampaignDescriptionServiceShouldReturnTwoCampaignDescriptions() {
        CampaignDescriptionRecords.add(new CampaignDescriptionRecord(CAMPAIGN_DESCRIPTION_CAMPAIGN1
                , CAMPAIGN_DESCRIPTION_DESCRIPTION1
                , CAMPAIGN_DESCRIPTION_START_DAY1
                , CAMPAIGN_DESCRIPTION_END_DAY1));
        CampaignDescriptionRecords.add(new CampaignDescriptionRecord(CAMPAIGN_DESCRIPTION_CAMPAIGN2
                , CAMPAIGN_DESCRIPTION_DESCRIPTION2
                , CAMPAIGN_DESCRIPTION_START_DAY2
                , CAMPAIGN_DESCRIPTION_END_DAY2));
        when(CampaignDescriptionRepository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(CampaignDescriptionRecords));
        Page<CampaignDescription> CampaignDescriptions = testCampaignDescriptionService.getCampaignDescriptions(mockPageable);
        Assert.assertNotNull("getCampaignDescriptions returned null", CampaignDescriptions);
        Assert.assertNotNull("CampaignDescriptions body does not exist"
                , CampaignDescriptions.getContent());
        Assert.assertEquals("not the correct number of CampaignDescriptions"
            , 2
            , CampaignDescriptions.getContent().size());
    }

    @Test
    public void testCampaignDescriptionServiceCampaignDescriptionRecordCampaignDescriptionConverterProperlyMapsCampaignDescription() {
        Converter<CampaignDescriptionRecord, CampaignDescription> testCampaignDescriptionRecordCampaignDescriptionConverter
                = testCampaignDescriptionService.getCampaignDescriptionRecordCampaignDescriptionConverter();

        Assert.assertNotNull(testCampaignDescriptionRecordCampaignDescriptionConverter);

        CampaignDescriptionRecord mockCampaignDescriptionRecord = new CampaignDescriptionRecord(CAMPAIGN_DESCRIPTION_CAMPAIGN1
                , CAMPAIGN_DESCRIPTION_DESCRIPTION1
                , CAMPAIGN_DESCRIPTION_START_DAY1
                , CAMPAIGN_DESCRIPTION_END_DAY1);

        CampaignDescription CampaignDescription = testCampaignDescriptionRecordCampaignDescriptionConverter.convert(mockCampaignDescriptionRecord);

        Assert.assertEquals("The Campaign was incorrectly converted"
                , CAMPAIGN_DESCRIPTION_CAMPAIGN1
                , CampaignDescription.getCampaign());
        Assert.assertEquals("The Description was incorrectly converted"
                , CAMPAIGN_DESCRIPTION_DESCRIPTION1
                , CampaignDescription.getDescription());
        Assert.assertEquals("The Start_Day was incorrectly converted"
                , CAMPAIGN_DESCRIPTION_START_DAY1
                , CampaignDescription.getStartDay());
        Assert.assertEquals("The END_Day was incorrectly converted"
                , CAMPAIGN_DESCRIPTION_END_DAY1
                , CampaignDescription.getEndDay());
    }



}
