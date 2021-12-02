package com.aumit;

import com.aumit.service.impl.CovidStatusServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CovidStatisticsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CovidStatisticsApplication.class, args);
    }

    @Bean
    public CovidStatusServiceImpl getCovidStatusImpl() {
        return new CovidStatusServiceImpl();
    }

}
