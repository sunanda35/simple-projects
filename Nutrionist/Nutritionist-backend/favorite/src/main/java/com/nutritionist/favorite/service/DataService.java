package com.nutritionist.favorite.service;

import com.nutritionist.favorite.domain.dataSchema.search.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class DataService {
    private final RestTemplate restTemplate;

    @Autowired
    public DataService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Data consumeApi(String api){
        return restTemplate.getForObject(api,Data.class);
    }
    public String favConsumeApi(String api){
        return restTemplate.getForObject(api, String.class);
    }
    public String recomendConsumeApi(String api){
        return restTemplate.getForObject(api, String.class);
    }
}
