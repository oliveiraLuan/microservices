package com.luandeoliveira.hr_api_gateway_zuul.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.ws.rs.HttpMethod;
import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private JwtTokenStore jwtTokenStore;

    private static final String PUBLIC_ROUTES = "/hr-oauth/oauth/token";

    private static final String OPERATOR_ROUTES = "/hr-worker/**";

    private static final String[] ADMIN_ROUTES = {"/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-oauth/actuator/**", "/hr-worker/actuator/**"};

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
        http.cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configurationSource = new CorsConfiguration();
        configurationSource.setAllowedOrigins(Arrays.asList("*"));
        configurationSource.setAllowCredentials(true);
        configurationSource.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
        configurationSource.setAllowedMethods(Arrays.asList("GET", "POST", "DELETE", "PUT", "PATCH"));

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configurationSource);
        return urlBasedCorsConfigurationSource;
    }
    @Bean
    public FilterRegistrationBean<CorsFilter> filterRegistrationBean(){
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(corsConfigurationSource()));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
}
