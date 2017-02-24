package com.e451.models;

import javax.persistence.*;

@Entity()
@Table(name = "product")
public class ProductRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long product_id;
    private String commodity_desc;
    private String sub_commodity_desc;
    private String manufacturer;
    private String department;
    private String brand;
    private String curr_size_of_product;

    public ProductRecord() {}

    public ProductRecord(String commodity_desc, String sub_commodity_desc, String manufacturer, String department, String brand, String curr_size_of_product) {
        this.commodity_desc = commodity_desc;
        this.sub_commodity_desc = sub_commodity_desc;
        this.manufacturer = manufacturer;
        this.department = department;
        this.brand = brand;
        this.curr_size_of_product = curr_size_of_product;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getCommodity_desc() {
        return commodity_desc;
    }

    public void setCommodity_desc(String commodity_desc) {
        this.commodity_desc = commodity_desc;
    }

    public String getSub_commodity_desc() {
        return sub_commodity_desc;
    }

    public void setSub_commodity_desc(String sub_commodity_desc) {
        this.sub_commodity_desc = sub_commodity_desc;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCurr_size_of_product() {
        return curr_size_of_product;
    }

    public void setCurr_size_of_product(String curr_size_of_product) {
        this.curr_size_of_product = curr_size_of_product;
    }
}
