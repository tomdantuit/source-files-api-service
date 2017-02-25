package com.e451.service;


import com.e451.domain.CouponRedemption;
import com.e451.models.CouponRedemptionRecord;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;

public interface CouponRedemptionService {
    Page<CouponRedemption> getCouponRedemptions(org.springframework.data.domain.Pageable pageable);
    Converter<CouponRedemptionRecord, CouponRedemption> getCouponRedemptionRecordCouponRedemptionConverter();
}
