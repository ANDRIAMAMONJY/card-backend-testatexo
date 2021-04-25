package com.cardgenerator.game.config;

import com.cardgenerator.game.service.CorsFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter(){
        FilterRegistrationBean<CorsFilter> registrationBean = new FilterRegistrationBean<>();    
        registrationBean.setFilter(new CorsFilter());
        registrationBean.addUrlPatterns("/api/v1/*");
        return registrationBean;    
    }
}
