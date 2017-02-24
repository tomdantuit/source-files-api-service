package com.e451.service;


import com.e451.domain.CampaignMembership;
import com.e451.models.CampaignMembershipRecord;
import com.e451.repository.CampaignMembershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CampaignMembershipServiceImpl implements CampaignMembershipService {

    CampaignMembershipRepository CampaignMembershipRepository;

    // Converter used to map a db entity to a domain object
    private static final Converter<CampaignMembershipRecord, CampaignMembership> CampaignMembershipRecordCampaignMembershipConverter
            = new Converter<CampaignMembershipRecord, CampaignMembership>() {
        @Override
        public CampaignMembership convert(CampaignMembershipRecord CampaignMembershipRecord) {

            return new CampaignMembership(CampaignMembershipRecord.getId()
                            , CampaignMembershipRecord.getHshdKey()
                            , CampaignMembershipRecord.getDescription());
        }
    };

    public Converter<CampaignMembershipRecord, CampaignMembership> getCampaignMembershipRecordCampaignMembershipConverter() {
        return CampaignMembershipRecordCampaignMembershipConverter;
    }

    @Autowired
    public CampaignMembershipServiceImpl(CampaignMembershipRepository CampaignMembershipRepository) {
        this.CampaignMembershipRepository = CampaignMembershipRepository;
    }

    @Override
    public Page<CampaignMembership> getCampaignMemberships(Pageable pageable) {

        Page<CampaignMembershipRecord> result = CampaignMembershipRepository.findAll(pageable);

        return result.map(CampaignMembershipRecordCampaignMembershipConverter);
    }

}
