package com.e451.service;

import com.e451.domain.CampaignMembership;
import com.e451.models.CampaignMembershipRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface CampaignMembershipService {

    Page<CampaignMembership> getCampaignMemberships(org.springframework.data.domain.Pageable pageable);
}
