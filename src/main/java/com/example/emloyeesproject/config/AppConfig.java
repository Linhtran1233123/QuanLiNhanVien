package com.example.emloyeesproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScans(@ComponentScan("com.example.emloyeesproject.cotroller"))
public class AppConfig implements WebMvcConfigurer {
//    @Bean //annotation đánh dấu đây là 1 Bean được quản lý
//    public InternalResourceViewResolver viewResolver1() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/view/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
    @Bean
     public InternalResourceViewResolver viewResolver(){
      return  new InternalResourceViewResolver("/WEB-INF/view",".jsp");
     }
}
