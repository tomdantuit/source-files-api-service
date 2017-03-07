package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "causal_data")
public class CausalRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Long storeId;
    private int weekNo;
    private String display;
    private String mailer;

    public CausalRecord() {}

    public CausalRecord(Long id, Long productId, Long storeId, int weekNo, String display, String mailer) {
        this.id = id;
        this.productId = productId;
        this.storeId = storeId;
        this.weekNo = weekNo;
        this.display = display;
        this.mailer = mailer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getMailer() {
        return mailer;
    }

    public void setMailer(String mailer) {
        this.mailer = mailer;
    }
}
