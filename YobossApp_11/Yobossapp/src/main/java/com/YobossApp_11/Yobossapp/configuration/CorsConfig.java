package com.YobossApp_11.Yobossapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {


    public WebMvcConfigurer corsConfigure(){
        return new WebMvcConfigurer() {
            
            @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/api/**")
                .allowedOrigins("http.locaahost:8082")
                .allowedMethods("GET", "POST", "PUT","DELETE")
                .allowCredentials(true);
            }


        };
    }
    
}
