package com.e451.models;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by e978726 on 2/26/2017.
 */

@Entity()
@Table(name = "transaction_data")
public class TransactionRecord {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long householdKey;
    private Long basketId;
    private Long day;
    private Long productId;
    private Long quantity;
    private double salesValue;
    private Long storeId;
    private double couponMatchDiscount;
    private double couponDisc;
    private double retailDisc;
    private Date transTime;
    private Long weekNo;

    public TransactionRecord() {}

    public TransactionRecord(Long householdKey, Long basketId, Long day, Long productId, Long quantity, double salesValue, Long storeId, double couponMatchDiscount, double couponDisc, double retailDisc, Date transTime, Long weekNo) {
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

    public double getSalesValue() {
        return salesValue;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public double getCouponMatchDiscount() {
        return couponMatchDiscount;
    }

    public void setCouponMatchDiscount(double couponMatchDiscount) {
        this.couponMatchDiscount = couponMatchDiscount;
    }

    public double getCouponDisc() {
        return couponDisc;
    }

    public void setCouponDisc(double couponDisc) {
        this.couponDisc = couponDisc;
    }

    public double getRetailDisc() {
        return retailDisc;
    }

    public void setRetailDisc(double retailDisc) {
        this.retailDisc = retailDisc;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Long getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(Long weekNo) {
        this.weekNo = weekNo;
    }


}
