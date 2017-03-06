package com.e451.model;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "campaign_desc")
public class CampaignDescriptionRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long campaign;
    private String description;
    private Date startDay;
    private Date endDay;

    public CampaignDescriptionRecord() {}

    public CampaignDescriptionRecord(Long campaign, String description, Date startDay, Date endDay) {
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

    public Date getStartDay() { return startDay; }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() { return endDay; }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

}
