package com.e451.domain;

/**
 * Created by k200745 on 2/23/2017.
 */
public class HouseholdDemographic {

    private Long householdKey;
    private String ageDescription;
    private String maritalStatusCode;
    private String incomeDesc;
    private String homeownerDesc;
    private String householdCompositionDesc;
    private String householdSizeDesc;
    private String kidCategoryDesc;

    public HouseholdDemographic(Long householdKey, String ageDescription, String maritalStatusCode, String incomeDesc, String homeownerDesc, String householdCompositionDesc, String householdSizeDesc, String kidCategoryDesc) {
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
