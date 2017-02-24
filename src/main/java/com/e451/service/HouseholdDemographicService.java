package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import org.springframework.data.domain.Page;

/**
 * Created by k200745 on 2/23/2017.
 */
public interface HouseholdDemographicService {
    Page<HouseholdDemographic> getHousehold(org.springframework.data.domain.Pageable pageable);
}
