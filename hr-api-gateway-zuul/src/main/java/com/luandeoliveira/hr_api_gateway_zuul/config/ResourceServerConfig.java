package com.luandeoliveira.hr_api_gateway_zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.ws.rs.HttpMethod;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private JwtTokenStore jwtTokenStore;

    private static final String PUBLIC_ROUTES = "/hr-oauth/oauth/token";

    private static final String OPERATOR_ROUTES = "/hr-worker/**";

    private static final String ADMIN_ROUTES = "/hr-payroll/**";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(jwtTokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http    .authorizeRequests()
                .antMatchers(PUBLIC_ROUTES).permitAll()
                .antMatchers(HttpMethod.GET, OPERATOR_ROUTES).hasAnyRole("OPERATOR", "ADMIN")
                .antMatchers(ADMIN_ROUTES).hasRole("ADMIN")
                .anyRequest().authenticated();
    }
}
