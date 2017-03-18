package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import com.e451.model.HouseholdDemographicRecord;
import com.e451.repository.HouseholdDemographicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDemographicServiceImpl implements HouseholdDemographicService{

    HouseholdDemographicRepository householdDemographicRepository;

    private static final Converter<HouseholdDemographicRecord, HouseholdDemographic> HouseholdDemographicRecordHouseholdDemographicConverter
            = new Converter<HouseholdDemographicRecord, HouseholdDemographic>() {

        @Override
        public HouseholdDemographic convert(HouseholdDemographicRecord householdDemographicRecord) {
            return new HouseholdDemographic(householdDemographicRecord.getHouseholdKey(),
                    householdDemographicRecord.getAgeDescription(),
                    householdDemographicRecord.getMaritalStatusCode(),
                    householdDemographicRecord.getIncomeDesc(),
                    householdDemographicRecord.getHomeownerDesc(),
                    householdDemographicRecord.getHouseholdCompositionDesc(),
                    householdDemographicRecord.getHouseholdSizeDesc(),
                    householdDemographicRecord.getKidCategoryDesc()
            );
        }
    };

    public Converter<HouseholdDemographicRecord, HouseholdDemographic> getHouseholdDemographicRecordHouseholdDemographicConverter() {
        return HouseholdDemographicRecordHouseholdDemographicConverter;
    }

    @Autowired
    public HouseholdDemographicServiceImpl(HouseholdDemographicRepository householdDemographicRepository) {
        this.householdDemographicRepository = householdDemographicRepository;
    }

    @Override
    public Page<HouseholdDemographic> getHouseholdDemographics(Pageable pageable) {
            Page<HouseholdDemographicRecord> result = householdDemographicRepository.findAll(pageable);
            return result.map(HouseholdDemographicRecordHouseholdDemographicConverter);
    }

}