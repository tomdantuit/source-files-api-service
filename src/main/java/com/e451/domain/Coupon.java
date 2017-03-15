package com.e451.domain;


public class Coupon {

    private long campaign;
    private long couponUpc;
    private long prodId;

    public Coupon(long campaign, long couponUpc, long prodId) {
        this.campaign = campaign;
        this.couponUpc = couponUpc;
        this.prodId = prodId;
    }

    public long getCampaign() {
        return campaign;
    }

    public void setCampaign(long campaign) {
        this.campaign = campaign;
    }

    public long getCouponUpc() {
        return couponUpc;
    }

    public void setCouponUpc(long couponUpc) {
        this.couponUpc = couponUpc;
    }

    public long getProdId() {
        return prodId;
    }

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

}
