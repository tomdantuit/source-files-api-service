package com.e451.service;


import com.e451.domain.Campaign;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignServiceImpl implements CampaignService {

    @Override
    public Page<Campaign> getCampaigns(Pageable pageable) {
        List<Campaign> campaigns = new ArrayList<>(1);

        campaigns.add(new Campaign(new Long(1)
                , new Long(2222)
                , "Description"));

        Page<Campaign> result = new PageImpl<Campaign>(campaigns);
        return result;
    }

}
