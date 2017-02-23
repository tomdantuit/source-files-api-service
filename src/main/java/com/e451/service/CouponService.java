package com.e451.service;


import com.e451.domain.Coupon;
import org.springframework.data.domain.Page;

public interface CouponService {

    Page<Coupon> getCoupons(org.springframework.data.domain.Pageable pageable);

}
