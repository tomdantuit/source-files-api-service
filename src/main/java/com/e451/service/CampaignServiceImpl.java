package com.e451.service;


import com.e451.domain.Campaign;
import com.e451.models.CampaignRecord;
import com.e451.repository.CampaignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    CampaignRepository campaignRepository;

    @Autowired
    public CampaignServiceImpl(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;
    }

    @Override
    public Page<Campaign> getCampaigns(Pageable pageable) {

        Page<CampaignRecord> result = campaignRepository.findAll(pageable);
        List<Campaign> campaigns = new ArrayList<>(result.getSize());

        for (CampaignRecord record :
                result) {
            campaigns.add(new Campaign(record.getId()
                ,record.getHshdKey()
            ,record.getDescription()));
        }

        return new PageImpl<Campaign>(campaigns);
    }

}
