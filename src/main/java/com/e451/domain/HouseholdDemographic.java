package com.e451.domain;

public class HouseholdDemographic {

    private Long householdKey;
    private String ageDescription;
    private String maritalStatusCode;
    private String incomeDescription;
    private String homeownerDescription;
    private String householdCompositionDescription;
    private String householdSizeDescription;
    private String kidCategoryDescription;

    public HouseholdDemographic(Long householdKey, String ageDescription, String maritalStatusCode,
                                String incomeDescription, String homeownerDescription, String householdCompositionDescription,
                                String householdSizeDescription, String kidCategoryDescription) {
        this.householdKey = householdKey;
        this.ageDescription = ageDescription;
        this.maritalStatusCode = maritalStatusCode;
        this.incomeDescription = incomeDescription;
        this.homeownerDescription = homeownerDescription;
        this.householdCompositionDescription = householdCompositionDescription;
        this.householdSizeDescription = householdSizeDescription;
        this.kidCategoryDescription = kidCategoryDescription;
    }

    public Long getHouseholdKey() { return householdKey; }

    public void setHouseholdKey(Long householdKey) { this.householdKey = householdKey; }

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

    public String getIncomeDescription() {
        return incomeDescription;
    }

    public void setIncomeDescription(String incomeDescription) {
        this.incomeDescription = incomeDescription;
    }

    public String getHomeownerDescription() {
        return homeownerDescription;
    }

    public void setHomeownerDescription(String homeownerDescription) {
        this.homeownerDescription = homeownerDescription;
    }

    public String getHouseholdCompositionDescription() {
        return householdCompositionDescription;
    }

    public void setHouseholdCompositionDescription(String householdCompositionDescription) {
        this.householdCompositionDescription = householdCompositionDescription;
    }

    public String getHouseholdSizeDescription() {
        return householdSizeDescription;
    }

    public void setHouseholdSizeDescription(String householdSizeDescription) {
        this.householdSizeDescription = householdSizeDescription;
    }

    public String getKidCategoryDescription() {
        return kidCategoryDescription;
    }

    public void setKidCategoryDescription(String kidCategoryDescription) {
        this.kidCategoryDescription = kidCategoryDescription;
    }
}
