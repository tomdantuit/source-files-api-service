package com.e451.service;


import com.e451.domain.CouponRedemption;
import org.springframework.data.domain.Page;

public interface CouponRedemptionService {
    Page<CouponRedemption> getCouponRedemptions(org.springframework.data.domain.Pageable pageable);

}
