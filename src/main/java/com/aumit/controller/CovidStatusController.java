package com.aumit.controller;

import com.aumit.service.impl.CovidStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/covidStatus")
public class CovidStatusController {

    @Autowired
    private CovidStatusServiceImpl covidStatusServiceImpl;

    @GetMapping("/statistics")
    public String getResults() {
        Object str = covidStatusServiceImpl.getLatestCovidStatistics();
        return str.toString();
    }

}
