package com.e451.models;

import javax.persistence.*;

@Entity()
@Table(name = "coupon_redempt")
public class CouponRedemptionRecord {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long household_key;
    private String day;
    private String coupon_upc;
    private String campaign;

    public CouponRedemptionRecord() {
    }

    public CouponRedemptionRecord(Long household_key, String day, String coupon_upc, String campaign) {
        this.household_key = household_key;
        this.day = day;
        this.coupon_upc = coupon_upc;
        this.campaign = campaign;
    }

    public Long getHousehold_key() {
        return household_key;
    }

    public void setHousehold_key(Long household_key) {
        this.household_key = household_key;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getCoupon_upc() {
        return coupon_upc;
    }

    public void setCoupon_upc(String coupon_upc) {
        this.coupon_upc = coupon_upc;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }
}
