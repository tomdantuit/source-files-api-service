package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "coupon_redempt")
public class CouponRedemptionRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long householdKey;
    private String day;
    private String couponUpc;
    private String campaign;

    public CouponRedemptionRecord() {
    }

    public CouponRedemptionRecord(Long householdKey, String day, String couponUpc, String campaign) {
        this.householdKey = householdKey;
        this.day = day;
        this.couponUpc = couponUpc;
        this.campaign = campaign;
    }

    public Long getHouseholdKey() {
        return householdKey;
    }

    public void setHouseholdKey(Long householdKey) {
        this.householdKey = householdKey;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCouponUpc() {
        return couponUpc;
    }

    public void setCouponUpc(String couponUpc) {
        this.couponUpc = couponUpc;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }
}
