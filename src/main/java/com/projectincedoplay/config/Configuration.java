package com.projectincedoplay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@org.springframework.context.annotation.Configuration
public class Configuration {
	@Value("${BackEndService.base.url}") 
	private String BEServiceBaseUrl;

	@Bean 
	public WebClient webclient()
	{
		return WebClient.builder().baseUrl(BEServiceBaseUrl).build();
	}
	
}
