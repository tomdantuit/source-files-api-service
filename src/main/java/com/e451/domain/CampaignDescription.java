package com.e451.domain;

import java.util.Date;

public class CampaignDescription {

    private Long campaign;
    private String description;
    private Date startDay;
    private Date endDay;

    public CampaignDescription(Long campaign, String description, Date startDay, Date endDay) {
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

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }
}
