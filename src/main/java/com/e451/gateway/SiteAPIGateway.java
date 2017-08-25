package com.e451.gateway;

import com.e451.gateway.model.User;
import org.springframework.stereotype.Service;

@Service
public interface SiteAPIGateway {
    User getUserByApiKey(String apiKey);
}
