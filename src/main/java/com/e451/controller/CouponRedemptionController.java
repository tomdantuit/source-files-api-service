package com.e451.controller;

import com.e451.domain.CouponRedemption;
import com.e451.service.CouponRedemptionService;
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
public class CouponRedemptionController {

    private CouponRedemptionService couponRedemptionService;

    @Autowired
    public CouponRedemptionController(CouponRedemptionService couponRedemptionService) {this.couponRedemptionService = couponRedemptionService;}

    @RequestMapping(path = "/couponRedemptions", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public HttpEntity<PagedResources<CouponRedemption>> getCouponRedemptions(Pageable pageable
            , PagedResourcesAssembler<CouponRedemption> pageResourceAssembler) {

        Page<CouponRedemption> couponRedemptions = couponRedemptionService.getCouponRedemptions(pageable);

        return new ResponseEntity(pageResourceAssembler.toResource(couponRedemptions), HttpStatus.OK);
    }

}
