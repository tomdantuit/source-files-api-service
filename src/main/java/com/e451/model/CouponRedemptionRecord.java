package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "coupon_redempt")
public class CouponRedemptionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long householdKey;
    private Long day;
    private Long couponUpc;
    private Long campaign;

    public CouponRedemptionRecord() {
    }

    public CouponRedemptionRecord(Long householdKey, Long campaign, Long couponUpc, Long day, Long id) {
        this.householdKey = householdKey;
        this.day = day;
        this.couponUpc = couponUpc;
        this.campaign = campaign;
        this.id  = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseholdKey() {
        return householdKey;
    }

    public void setHouseholdKey(Long householdKey) {
        this.householdKey = householdKey;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getCouponUpc() {
        return couponUpc;
    }

    public void setCouponUpc(Long couponUpc) {
        this.couponUpc = couponUpc;
    }

    public Long getCampaign() {
        return campaign;
    }

    public void setCampaign(Long campaign) {
        this.campaign = campaign;
    }
}
