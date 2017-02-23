package com.e451.repository;


import com.e451.models.CampaignRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignRepository extends PagingAndSortingRepository<CampaignRecord, Long> {
}
