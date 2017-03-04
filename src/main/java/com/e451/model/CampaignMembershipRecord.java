package com.e451.model;

import javax.persistence.*;

@Entity()
@Table(name = "campaign_table")
public class CampaignMembershipRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long campaignId;
    private Long hshdKey;
    private String description;

    public CampaignMembershipRecord() {}

    public CampaignMembershipRecord(Long id, Long hshdKey, String description, Long campaignId) {
        this.id = id;
        this.hshdKey = hshdKey;
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

    public Long getHshdKey() {
        return hshdKey;
    }

    public void setHshdKey(Long hshdKey) {
        this.hshdKey = hshdKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
