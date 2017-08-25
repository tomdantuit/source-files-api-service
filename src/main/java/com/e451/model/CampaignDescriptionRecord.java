package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "campaign_desc")
public class CampaignDescriptionRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long campaign;
    private String description;
    private Long startDay;
    private Long endDay;

    public CampaignDescriptionRecord() {}

    public CampaignDescriptionRecord(Long campaign, String description, Long startDay, Long endDay) {
        this.campaign = campaign;
        this.description = description;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public Long getCampaign() {
        return campaign;
    };

    public void setCampaign(Long campaign) {
        this.campaign = campaign;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStartDay() { return startDay; }

    public void setStartDay(Long startDay) {
        this.startDay = startDay;
    }

    public Long getEndDay() { return endDay; }

    public void setEndDay(Long endDay) {
        this.endDay = endDay;
    }

}
