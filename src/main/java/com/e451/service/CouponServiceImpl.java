package com.e451.service;


import com.e451.domain.Coupon;
import com.e451.model.CouponRecord;
import com.e451.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository;
    private Converter<CouponRecord, Coupon> couponRecordCouponConverter = new Converter<CouponRecord, Coupon>() {
        @Override
        public Coupon convert(CouponRecord couponRecord) {
            return new Coupon(couponRecord.getCampaign()
                , couponRecord.getCouponUpc()
                , couponRecord.getProductId());
        }
    };

    Converter<CouponRecord, Coupon> getCouponRecordCouponConverter() {
        return couponRecordCouponConverter;
    }

    @Autowired
    CouponServiceImpl(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    @Override
    public Page<Coupon> getCoupons(Pageable pageable) {
        Page<CouponRecord> couponRecords = couponRepository.findAll(pageable);
        return couponRecords.map(couponRecordCouponConverter);
    }
}
