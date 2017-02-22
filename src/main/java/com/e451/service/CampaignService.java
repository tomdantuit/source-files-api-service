package com.e451.service;

import com.e451.domain.Campaign;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface CampaignService {

    Page<Campaign> getCampaigns(org.springframework.data.domain.Pageable pageable);
}
