package com.bosonit.restservice.config;

import com.bosonit.restservice.impl.CityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityConfig {

    @Bean
    public CityServiceImpl getCityService() {
        CityServiceImpl csi = new CityServiceImpl();
        csi.addCity("Zaragoza", 64624);
        csi.addCity("Valencia", 75425);
        csi.addCity("Roma", 1713);
        csi.addCity("Paris", 24573);
        csi.addCity("Madrid", 135235);
        return csi;
    }

}
