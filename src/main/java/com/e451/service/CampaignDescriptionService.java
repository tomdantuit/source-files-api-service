package com.e451.service;


import com.e451.domain.CampaignDescription;
import org.springframework.data.domain.Page;

public interface CampaignDescriptionService {

    Page<CampaignDescription> getCampaignDescriptions(org.springframework.data.domain.Pageable pageable);
}
