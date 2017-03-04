package com.e451.controller;

import com.e451.domain.Coupon;
import com.e451.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {this.couponService = couponService;}

    @RequestMapping(path="/coupon", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<Coupon>> getCoupons(Pageable pageable
            , PagedResourcesAssembler<Coupon> pageResourceAssembler) {
        Page<Coupon> coupons = couponService.getCoupons(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(coupons),
                HttpStatus.OK);
    }
}
