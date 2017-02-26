package com.e451.service;


import com.e451.domain.CampaignDescription;
import com.e451.models.CampaignDescriptionRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface CampaignDescriptionService {

    Page<CampaignDescription> getCampaignDescriptions(org.springframework.data.domain.Pageable pageable);
    Converter<CampaignDescriptionRecord, CampaignDescription> getCampaignDescriptionRecordCampaignDescriptionConverter();
}
