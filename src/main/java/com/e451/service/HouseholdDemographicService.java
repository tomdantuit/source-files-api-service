package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import com.e451.models.HouseholdDemographicRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface HouseholdDemographicService {
    Page<HouseholdDemographic> getHouseholdDemographics(org.springframework.data.domain.Pageable pageable);
    Converter<HouseholdDemographicRecord, HouseholdDemographic> getHouseholdDemographicRecordHouseholdDemographicConverter();
}
