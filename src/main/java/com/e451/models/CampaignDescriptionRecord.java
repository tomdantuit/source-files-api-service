package com.e451.models;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "campaign_desc")
public class CampaignDescriptionRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long campaign;
    private String description;
    private Date start_day;
    private Date end_day;

    public CampaignDescriptionRecord() {}

    public CampaignDescriptionRecord(Long campaign, String description, Date start_day, Date end_day) {
        this.campaign = campaign;
        this.description = description;
        this.start_day = start_day;
        this.end_day = end_day;
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

    public Date getStart_day() { return start_day; }

    public void setStart_day(Date start_day) {
        this.start_day = start_day;
    }

    public Date getEnd_day() { return end_day; }

    public void setEnd_day(Date end_day) {
        this.end_day = end_day;
    }

}
