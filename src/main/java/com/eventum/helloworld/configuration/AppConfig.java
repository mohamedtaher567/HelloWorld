package com.eventum.helloworld.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver()
	{
		InternalResourceViewResolver  internalResourceBiewResolver = new InternalResourceViewResolver();
		internalResourceBiewResolver.setPrefix("/WEB-INF/views/");
		internalResourceBiewResolver.setSuffix(".jsp");
		return internalResourceBiewResolver;
	}
		
	
}
