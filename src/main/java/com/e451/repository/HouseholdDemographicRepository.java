package com.e451.repository;

import com.e451.models.HouseholdDemographicRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by b527047 on 3/2/2017.
 */

@Repository
public interface HouseholdDemographicRepository extends PagingAndSortingRepository<HouseholdDemographicRecord, Long>{
}
