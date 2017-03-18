package com.e451.model;

import javax.persistence.*;

@Entity
@Table(name="hh_demographic")
public class HouseholdDemographicRecord {

    @Id
    @Column(name="HOUSEHOLD_KEY")
    private Long householdKey;
    @Column(name="AGE_DESC")
    private String ageDescription;
    @Column(name="MARITAL_STATUS_CODE")
    private String maritalStatusCode;
    @Column(name="INCOME_DESC")
    private String incomeDesc;
    @Column(name="HOMEOWNER_DESC")
    private String homeownerDesc;
    @Column(name="HH_COMP_DESC")
    private String householdCompositionDesc;
    @Column(name="HOUSEHOLD_SIZE_DESC")
    private String householdSizeDesc;
    @Column(name="KID_CATEGORY_DESC")
    private String kidCategoryDesc;

    public HouseholdDemographicRecord() {}

    public HouseholdDemographicRecord(Long householdKey, String ageDescription, String maritalStatusCode, String incomeDesc, String homeownerDesc, String householdCompositionDesc, String householdSizeDesc, String kidCategoryDesc) {
        this.householdKey = householdKey;
        this.ageDescription = ageDescription;
        this.maritalStatusCode = maritalStatusCode;
        this.incomeDesc = incomeDesc;
        this.homeownerDesc = homeownerDesc;
        this.householdCompositionDesc = householdCompositionDesc;
        this.householdSizeDesc = householdSizeDesc;
        this.kidCategoryDesc = kidCategoryDesc;
    }

    public Long getHouseholdKey() {
        return householdKey;
    }

    public void setHouseholdKey(Long householdKey) {
        this.householdKey = householdKey;
    }

    public String getAgeDescription() {
        return ageDescription;
    }

    public void setAgeDescription(String ageDescription) {
        this.ageDescription = ageDescription;
    }

    public String getMaritalStatusCode() {
        return maritalStatusCode;
    }

    public void setMaritalStatusCode(String maritalStatusCode) {
        this.maritalStatusCode = maritalStatusCode;
    }

    public String getIncomeDesc() {
        return incomeDesc;
    }

    public void setIncomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc;
    }

    public String getHomeownerDesc() {
        return homeownerDesc;
    }

    public void setHomeownerDesc(String homeownerDesc) {
        this.homeownerDesc = homeownerDesc;
    }

    public String getHouseholdCompositionDesc() {
        return householdCompositionDesc;
    }

    public void setHouseholdCompositionDesc(String householdCompositionDesc) {
        this.householdCompositionDesc = householdCompositionDesc;
    }

    public String getHouseholdSizeDesc() {
        return householdSizeDesc;
    }

    public void setHouseholdSizeDesc(String householdSizeDesc) {
        this.householdSizeDesc = householdSizeDesc;
    }

    public String getKidCategoryDesc() {
        return kidCategoryDesc;
    }

    public void setKidCategoryDesc(String kidCategoryDesc) {
        this.kidCategoryDesc = kidCategoryDesc;
    }
}
