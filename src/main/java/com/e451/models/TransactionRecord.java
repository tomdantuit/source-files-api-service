package com.e451.models;

import javax.persistence.*;

@Entity()
@Table(name = "transaction_data")
public class TransactionRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long householdKey;
    private Long basketId;
    private Long day;
    private Long productId;
    private Long quantity;
    private Double salesValue;
    private Long storeId;
    private Double couponMatchDiscount;
    private Double couponDisc;
    private Double retailDisc;
    private Long transTime;
    private Long weekNo;

    public TransactionRecord() {}

    public TransactionRecord(Long id, Long householdKey, Long basketId, Long day,
                             Long productId, Long quantity, Double salesValue,
                             Long storeId, Double couponMatchDiscount, Double couponDisc,
                             Double retailDisc, Long transTime, Long weekNo) {
        this.id = id;
        this.householdKey = householdKey;
        this.basketId = basketId;
        this.day = day;
        this.productId = productId;
        this.quantity = quantity;
        this.salesValue = salesValue;
        this.storeId = storeId;
        this.couponMatchDiscount = couponMatchDiscount;
        this.couponDisc = couponDisc;
        this.retailDisc = retailDisc;
        this.transTime = transTime;
        this.weekNo = weekNo;
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

    public Long getBasketId() {
        return basketId;
    }

    public void setBasketId(Long basketId) {
        this.basketId = basketId;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(Double salesValue) {
        this.salesValue = salesValue;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Double getCouponMatchDiscount() {
        return couponMatchDiscount;
    }

    public void setCouponMatchDiscount(Double couponMatchDiscount) {
        this.couponMatchDiscount = couponMatchDiscount;
    }

    public Double getCouponDisc() {
        return couponDisc;
    }

    public void setCouponDisc(Double couponDisc) {
        this.couponDisc = couponDisc;
    }

    public Double getRetailDisc() {
        return retailDisc;
    }

    public void setRetailDisc(Double retailDisc) {
        this.retailDisc = retailDisc;
    }

    public Long getTransTime() {
        return transTime;
    }

    public void setTransTime(Long transTime) {
        this.transTime = transTime;
    }

    public Long getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Long weekNo) {
        this.weekNo = weekNo;
    }


}
