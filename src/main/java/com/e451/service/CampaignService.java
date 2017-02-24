package com.e451.service;

import com.e451.domain.Campaign;
import com.e451.models.CampaignRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface CampaignService {

    Page<Campaign> getCampaigns(org.springframework.data.domain.Pageable pageable);
    Converter<CampaignRecord, Campaign> getCampaignRecordCampaignConverter();
}
