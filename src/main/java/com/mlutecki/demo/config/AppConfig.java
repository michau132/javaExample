package com.mlutecki.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mlutecki.demo")
public class AppConfig {

    @Bean
    public ViewResolver viewResolver(){
        //chyba nie potrzebny
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();


        return viewResolver;
    }
}
