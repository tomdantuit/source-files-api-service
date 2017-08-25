package com.e451.gateway;

import com.e451.gateway.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

public class SiteAPIGatewayImpl implements SiteAPIGateway {

    @Value("${site.api.url}")
    private String siteApiUrl;

    public String getSiteApiUrl() {
        return siteApiUrl;
    }

    public void setSiteApiUrl(String siteApiUrl) {
        this.siteApiUrl = siteApiUrl;
    }

    public SiteAPIGatewayImpl(){}

    public SiteAPIGatewayImpl(String siteApiUrl) {
        this.siteApiUrl = siteApiUrl;
    }

    @Override
    public User getUserByApiKey(String apiKey) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(siteApiUrl);
        uriComponentsBuilder.pathSegment("userByKey").path(apiKey);
        User user = null;
        ResponseEntity<User> forEntity = restTemplateBuilder.build().getForEntity(uriComponentsBuilder.build().toUriString().toString()
                , User.class
                , user);
        user = forEntity.getBody();
        return user;
    }
}
