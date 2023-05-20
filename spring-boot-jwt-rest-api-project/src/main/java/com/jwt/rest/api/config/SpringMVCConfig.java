package com.jwt.rest.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jwt.rest.api.intercepter.UserSecurityInterceptor;

@Configuration
public class SpringMVCConfig implements WebMvcConfigurer {

	
	private UserSecurityInterceptor userSecurityInterceptor;
	
	@Autowired
	public void setUserSecurityInterceptor(UserSecurityInterceptor userSecurityInterceptor) {
		this.userSecurityInterceptor = userSecurityInterceptor;
	}


	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(userSecurityInterceptor).addPathPatterns("/**").excludePathPatterns("/api/auth/**");
	}

}