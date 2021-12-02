package com.aumit.service.impl;

import com.aumit.service.CovidStatusService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

public class CovidStatusServiceImpl implements CovidStatusService {

    RestTemplate restTemplate;

    HttpHeaders httpHeaders;

    @PostConstruct
    public void init() {
        restTemplate = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCEPT, "*/*");
        httpHeaders.add("x-rapidapi-host", "covid-193.p.rapidapi.com");
        httpHeaders.add("x-rapidapi-key", "f07bfc9241mshd1dd8aeb20338abp19727ejsn70522447fcab");
    }

    @Override
    public Object getLatestCovidStatistics() {
        HttpEntity<?> entity = new HttpEntity<>(httpHeaders);
        UriComponentsBuilder url = UriComponentsBuilder.fromHttpUrl("https://covid-193.p.rapidapi.com/statistics");

        ResponseEntity<Object> httpResponse = null;
        //Object httpResponse = null;

        try {
            httpResponse = restTemplate.exchange(url.toUriString(), HttpMethod.GET, entity, Object.class);
            // httpResponse = restTemplate.exchange("https://covid-193.p.rapidapi.com/statistics", HttpMethod.GET, entity, Object.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return  httpResponse.getBody();
    }

}
