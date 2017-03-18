package com.e451.repository;

import com.e451.model.HouseholdDemographicRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdDemographicRepository extends PagingAndSortingRepository<HouseholdDemographicRecord, Long>{
}
