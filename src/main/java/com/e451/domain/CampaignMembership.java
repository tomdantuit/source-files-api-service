package com.e451.domain;

public class CampaignMembership {

    private Long id;
    private Long hshdKey;
    private String description;
    private Long campaignId;

    public CampaignMembership(Long id, Long hshdKey, String description, Long campaignId) {
        this.id = id;
        this.hshdKey = hshdKey;
        this.description = description;
        this.campaignId = campaignId;
    }

    public Long getCampaignId() {
        return campaignId;
    }

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
