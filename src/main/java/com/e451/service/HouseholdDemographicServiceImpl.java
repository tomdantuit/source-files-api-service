package com.e451.service;

import com.e451.domain.HouseholdDemographic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k200745 on 2/23/2017.
 */
public class HouseholdDemographicServiceImpl implements HouseholdDemographicService{
    @Override
    public Page<HouseholdDemographic> getHousehold(Pageable pageable) {
            List<HouseholdDemographic> householdDemographics = new ArrayList<>(1);

        householdDemographics.add(new HouseholdDemographic(new Long(208)
                , "45-54"
                , "U"
                , "50-74K"
                , "Homeowner"
                , "2 Adults No Kids"
                , "2"
                , "None/Unknown"));

            Page<HouseholdDemographic> result = new PageImpl<HouseholdDemographic>(householdDemographics);
            return result;

    }
}
