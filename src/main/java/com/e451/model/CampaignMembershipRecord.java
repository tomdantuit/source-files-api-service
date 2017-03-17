package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "campaign_table")
public class CampaignMembershipRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(name = "campaign")
    private Long campaignId;
    private Long householdKey;
    private String description;

    public CampaignMembershipRecord() {}

    public CampaignMembershipRecord(Long id, Long householdKey, String description, Long campaignId) {
        this.id = id;
        this.householdKey = householdKey;
        this.description = description;
        this.campaignId = campaignId;
    }

        public Long getCampaignId() {
        return campaignId;
    };

    public void setCampaignId(Long campaignId) {
        this.campaignId = campaignId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHouseholdKey() {
        return householdKey;
    }

    public void setHouseholdKey(Long householdKey) {
        this.householdKey = householdKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
