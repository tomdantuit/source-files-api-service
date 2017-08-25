package com.e451.configuration;

import com.e451.configuration.filter.ApiKeyFilter;
import com.e451.gateway.SiteAPIGateway;
import com.e451.gateway.SiteAPIGatewayImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${site.api.url}")
    private String siteApiUrl;

    SiteAPIGateway siteAPIGateway;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        siteAPIGateway = new SiteAPIGatewayImpl(siteApiUrl);
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterAfter(new ApiKeyFilter(siteAPIGateway), BasicAuthenticationFilter.class);
    }
}
