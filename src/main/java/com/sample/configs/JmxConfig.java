package com.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;

import com.sample.jmx.UserMbean;

@Configuration
@EnableMBeanExport
public class JmxConfig {
	@Bean
	public UserMbean jmxResource() {
		return new UserMbean();
	}
}
