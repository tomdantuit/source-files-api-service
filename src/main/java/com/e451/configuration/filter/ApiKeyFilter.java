package com.e451.configuration.filter;

import com.e451.gateway.SiteAPIGateway;
import com.e451.gateway.model.User;
import org.apache.catalina.authenticator.BasicAuthenticator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ApiKeyFilter  extends GenericFilterBean{

    private static final Logger LOG = LogManager.getLogger(ApiKeyFilter.class);

    SiteAPIGateway siteAPIGateway;

    public ApiKeyFilter(SiteAPIGateway siteAPIGateway) {
        this.siteAPIGateway = siteAPIGateway;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        String apiKey = ((HttpServletRequest) servletRequest).getHeader("x-8451");
        User user = null;
        if( apiKey != null) {
            user = siteAPIGateway.getUserByApiKey(apiKey);
            if(user != null && !user.getUsername().equals("Anonymous")) {
                Authentication authentication = new e451Authentication(user);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                LOG.info(toString().format("SUCCESS: call made with API Key: %s, user: %s on call to %s"
                        , apiKey
                        , user.getUsername()
                        , ((HttpServletRequest)servletRequest).getRequestURL()));

                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                LOG.info(toString().format("INVALID_ACCESS: Invalid API key: %s on call to %s"
                        , apiKey
                        , ((HttpServletRequest)servletRequest).getRequestURL()));
                ((HttpServletResponse)servletResponse).sendError(HttpStatus.FORBIDDEN.value()
                    , "Invalid API key in x-8451 header");
            }
        } else {
            LOG.info(toString().format("INVALID_ACCESS: No x-8451 header on call to: %s"
                    , ((HttpServletRequest)servletRequest).getRequestURL()));
            ((HttpServletResponse)servletResponse).sendError(HttpStatus.UNAUTHORIZED.value()
                    , "x-8451 header not present");
        }
    }

    class e451Authentication implements Authentication {

        User principal = null;
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        public e451Authentication(User user) {
            this.principal = user;
            this.grantedAuthorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });
        }

        public e451Authentication(User user, List<GrantedAuthority> authorities) {
            this.principal = user;
            this.grantedAuthorities = authorities;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return grantedAuthorities;
        }

        @Override
        public Object getCredentials() {
            return null;
        }

        @Override
        public Object getDetails() {
            return principal;
        }

        @Override
        public Object getPrincipal() {
            return principal;
        }

        @Override
        public boolean isAuthenticated() {
            return this.principal.getHasAcceptedTermsValue();
        }

        @Override
        public void setAuthenticated(boolean b) throws IllegalArgumentException {
            this.principal.setHasAcceptedTerms(b);
        }

        @Override
        public String getName() {
            return principal.getName();
        }
    }
}
