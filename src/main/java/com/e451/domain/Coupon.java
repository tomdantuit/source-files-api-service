package com.e451.domain;


public class Coupon {

    private long campaign;
    private long coupon_upc;
    private long prod_id;

    public Coupon(long campaign, long coupon_upc, long prod_id) {
        this.campaign = campaign;
        this.coupon_upc = coupon_upc;
        this.prod_id = prod_id;
    }

    public long getCampaign() {
        return campaign;
    }

    public void setCampaign(long campaign) {
        this.campaign = campaign;
    }

    public long getCoupon_upc() {
        return coupon_upc;
    }

    public void setCoupon_upc(long coupon_upc) {
        this.coupon_upc = coupon_upc;
    }

    public long getProd_id() {
        return prod_id;
    }

    public void setProd_id(long prod_id) {
        this.prod_id = prod_id;
    }

}
