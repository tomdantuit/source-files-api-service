package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "product")
public class ProductRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long productId;
    private String commodityDesc;
    private String subCommodityDesc;
    private String manufacturer;
    private String department;
    private String brand;
    @Column(name="curr_size_of_product")
    private String currentSizeOfProduct;

    public ProductRecord() {}

    public ProductRecord(Long productId, String commodityDesc, String subCommodityDesc, String manufacturer, String department, String brand, String currentSizeOfProduct) {
        this.productId = productId;
        this.commodityDesc = commodityDesc;
        this.subCommodityDesc = subCommodityDesc;
        this.manufacturer = manufacturer;
        this.department = department;
        this.brand = brand;
        this.currentSizeOfProduct = currentSizeOfProduct;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCommodityDesc() {
        return commodityDesc;
    }

    public void setCommodityDesc(String commodityDesc) {
        this.commodityDesc = commodityDesc;
    }

    public String getSubCommodityDesc() {
        return subCommodityDesc;
    }

    public void setSubCommodityDesc(String subCommodityDesc) {
        this.subCommodityDesc = subCommodityDesc;
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

    public String getCurrentSizeOfProduct() {
        return currentSizeOfProduct;
    }

    public void setCurrentSizeOfProduct(String currentSizeOfProduct) {
        this.currentSizeOfProduct = currentSizeOfProduct;
    }
}
