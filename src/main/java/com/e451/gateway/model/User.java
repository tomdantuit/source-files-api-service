package com.e451.gateway.model;

public class User {
    private String name;
    private String username;
    private String hasAcceptedTerms = Boolean.FALSE.toString();

    public User(){}
    public User(String name, String username, boolean hasAcceptedTerms) {
        this.name = name;
        this.username = username;
        setHasAcceptedTerms(hasAcceptedTerms);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHasAcceptedTerms() {
        return hasAcceptedTerms;
    }

    public boolean getHasAcceptedTermsValue() {
        return hasAcceptedTerms.equals(Boolean.TRUE.toString());
    }

    public void setHasAcceptedTerms(boolean hasAcceptedTerms) {
        this.hasAcceptedTerms = hasAcceptedTerms ? Boolean.TRUE.toString() : Boolean.FALSE.toString();
    }
}
