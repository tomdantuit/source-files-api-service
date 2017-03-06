package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "causal_table")
public class CausalRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long product_id;
    private Long store_id;
    private int week_no;
    private String display;
    private String mailer;

    public CausalRecord() {}

    public CausalRecord(Long id, Long product_id, Long store_id, int week_no, String display, String mailer) {
        this.id = id;
        this.product_id = product_id;
        this.store_id = store_id;
        this.week_no = week_no;
        this.display = display;
        this.mailer = mailer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public Long getStore_id() {
        return store_id;
    }

    public void setStore_id(Long store_id) {
        this.store_id = store_id;
    }

    public int getWeek_no() {
        return week_no;
    }

    public void setWeek_no(int week_no) {
        this.week_no = week_no;
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
