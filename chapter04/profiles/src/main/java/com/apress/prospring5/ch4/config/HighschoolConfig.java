package com.apress.prospring5.ch4.config;

import com.apress.prospring5.ch4.FoodProviderService;
import com.apress.prospring5.ch4.highschool.FoodProviderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("highschool")
public class HighschoolConfig {

    @Bean
    public FoodProviderService foodProviderService(){
        return new FoodProviderServiceImpl();
    }
}
