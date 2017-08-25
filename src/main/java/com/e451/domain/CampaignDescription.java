package com.e451.domain;

public class CampaignDescription {

    private Long campaign;
    private String description;
    private Long startDay;
    private Long endDay;

    public CampaignDescription(Long campaign, String description, Long startDay, Long endDay) {
        this.campaign = campaign;
        this.description = description;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Long getCampaign() {
        return campaign;
    }

    public void setCampaign(Long campaign) {
        this.campaign = campaign;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartDay() {
        return startDay;
    }

    public void setStartDay(Long startDay) {
        this.startDay = startDay;
    }

    public Long getEndDay() {
        return endDay;
    }

    public void setEndDay(Long endDay) {
        this.endDay = endDay;
    }
}
