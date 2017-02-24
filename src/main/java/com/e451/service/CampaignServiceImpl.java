package com.e451.service;


import com.e451.domain.Campaign;
import com.e451.models.CampaignRecord;
import com.e451.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    CampaignRepository campaignRepository;

    // Converter used to map a db entity to a domain object
    private static final Converter<CampaignRecord, Campaign> campaignRecordCampaignConverter
            = new Converter<CampaignRecord, Campaign>() {
        @Override
        public Campaign convert(CampaignRecord campaignRecord) {

            return new Campaign(campaignRecord.getId()
                            , campaignRecord.getHshdKey()
                            , campaignRecord.getDescription());
        }
    };

    public Converter<CampaignRecord, Campaign> getCampaignRecordCampaignConverter() {
        return campaignRecordCampaignConverter;
    }

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Page<Campaign> getCampaigns(Pageable pageable) {

        Page<CampaignRecord> result = campaignRepository.findAll(pageable);

        return result.map(campaignRecordCampaignConverter);
    }

}
