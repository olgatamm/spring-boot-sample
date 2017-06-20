package com.sample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration 
@ComponentScan("com.sample") 
@EnableWebMvc   
public class ApplicationConfig {  
    @Bean  
    public InternalResourceViewResolver viewResolver() {  
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();  
        resolver.setPrefix("/templates/");  
        resolver.setSuffix(".html");
        return resolver;  
    }
}