package com.e451.service;


import com.e451.domain.CouponRedemption;
import com.e451.model.CouponRedemptionRecord;
import com.e451.repository.CouponRedemptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CouponRedemptionServiceImpl implements CouponRedemptionService {

    CouponRedemptionRepository couponRedemptionRepository;

    public CouponRedemptionRepository getCouponRedemptionRepository() {
        return couponRedemptionRepository;
    }

    private static final Converter<CouponRedemptionRecord, CouponRedemption> CouponRedemptionRecordCouponRedemptionConverter
            = new Converter<CouponRedemptionRecord, CouponRedemption>() {
        @Override
        public CouponRedemption convert(CouponRedemptionRecord couponRedemptionRecord) {

            return new CouponRedemption(couponRedemptionRecord.getHouseholdKey(),
                    couponRedemptionRecord.getDay(),
                    couponRedemptionRecord.getCouponUpc(),
                    couponRedemptionRecord.getCampaign());
        }
    };

    Converter<CouponRedemptionRecord, CouponRedemption> getCouponRedemptionRecordCouponRedemptionConverter() {
        return CouponRedemptionRecordCouponRedemptionConverter;
    }


    @Autowired
    public CouponRedemptionServiceImpl(CouponRedemptionRepository couponRedemptionRepository) {
        this.couponRedemptionRepository = couponRedemptionRepository;
    }

    @Override
    public Page<CouponRedemption> getCouponRedemptions(Pageable pageable) {

        Page<CouponRedemptionRecord> result = couponRedemptionRepository.findAll(pageable);

        return result.map(CouponRedemptionRecordCouponRedemptionConverter);
    }

}
