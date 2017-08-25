package com.e451.domain;


public class Coupon {

    private long campaign;
    private long couponUpc;
    private long productId;

    public Coupon(long campaign, long couponUpc, long productId) {
        this.campaign = campaign;
        this.couponUpc = couponUpc;
        this.productId = productId;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

}
