package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import com.e451.models.HouseholdDemographicRecord;
import com.e451.repository.HouseholdDemographicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k200745 on 2/23/2017.
 */
@Service
public class HouseholdDemographicServiceImpl implements HouseholdDemographicService{

    private HouseholdDemographicRepository householdDemographicRepository;

    private Converter<HouseholdDemographicRecord, HouseholdDemographic> converter
                = householdDemographicRecord -> new HouseholdDemographic(householdDemographicRecord.getHshdKey()
        , householdDemographicRecord.getAgeDescription()
        , householdDemographicRecord.getMaritalStatusCode()
        , householdDemographicRecord.getIncomeDesc()
        , householdDemographicRecord.getHomeownerDesc()
        , householdDemographicRecord.getHouseholdCompositionDesc()
        , householdDemographicRecord.getHouseholdSizeDesc()
        , householdDemographicRecord.getKidCategoryDesc());

    @Autowired
    public HouseholdDemographicServiceImpl(HouseholdDemographicRepository householdDemographicRepository) {
        this.householdDemographicRepository = householdDemographicRepository;
    }

    @Override
    public Page<HouseholdDemographic> getHouseholdDemographics(Pageable pageable) {
            Page<HouseholdDemographicRecord> result = householdDemographicRepository.findAll(pageable);
            return result.map(converter);
    }
}