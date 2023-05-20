package com.criteria.query.rest.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.criteria.query.rest.api.filters.JwtAuthenticationFilter;

@Configuration
public class AppConfig {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(new JwtAuthenticationFilter());
        filter.addUrlPatterns("/api/persons/*");
        filter.addUrlPatterns("/api/users/*");
        return filter;
    }

}
