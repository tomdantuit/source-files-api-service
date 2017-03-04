package com.e451.domain;

public class CouponRedemption {
    private Long householdKey;
    private String day;
    private String couponUpc;
    private String campaign;

    public CouponRedemption() {
    }

    public CouponRedemption(Long householdKey, String day, String couponUpc, String campaign) {
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
