package com.e451.repository;


import com.e451.model.CampaignDescriptionRecord;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampaignDescriptionRepository extends PagingAndSortingRepository<CampaignDescriptionRecord, Long> {
}
