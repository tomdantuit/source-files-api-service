package com.e451.service;


import com.e451.domain.CampaignDescription;
import com.e451.model.CampaignDescriptionRecord;
import com.e451.repository.CampaignDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampaignDescriptionServiceImpl implements CampaignDescriptionService {

    CampaignDescriptionRepository CampaignDescriptionRepository;

    // Converter used to map a db entity to a domain object
    private static final Converter<CampaignDescriptionRecord, CampaignDescription> CampaignDescriptionRecordCampaignDescriptionConverter
            = new Converter<CampaignDescriptionRecord, CampaignDescription>() {
        @Override
        public CampaignDescription convert(CampaignDescriptionRecord campaignDescriptionRecord) {

            return new CampaignDescription(campaignDescriptionRecord.getCampaign()
                            , campaignDescriptionRecord.getDescription()
                            , campaignDescriptionRecord.getStartDay()
                            , campaignDescriptionRecord.getEndDay());
        }
    };

    Converter<CampaignDescriptionRecord, CampaignDescription> getCampaignDescriptionRecordCampaignDescriptionConverter() {
        return CampaignDescriptionRecordCampaignDescriptionConverter;
    }

    @Autowired
    public CampaignDescriptionServiceImpl(CampaignDescriptionRepository CampaignDescriptionRepository) {
        this.CampaignDescriptionRepository = CampaignDescriptionRepository;
    }

    @Override
    public Page<CampaignDescription> getCampaignDescriptions(Pageable pageable) {

        Page<CampaignDescriptionRecord> result = CampaignDescriptionRepository.findAll(pageable);

        return result.map(CampaignDescriptionRecordCampaignDescriptionConverter);
    }

}

