package com.e451.service;


import com.e451.domain.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Override
    public Page<Coupon> getCoupons(Pageable pageable) {
        List<Coupon> coupons = new ArrayList<>(1);

        coupons.add(new Coupon(new Long(1)
                , new Long(2222)
                , new Long(1234)));

        Page<Coupon> result = new PageImpl<Coupon>(coupons);
        return result;
    }
}
