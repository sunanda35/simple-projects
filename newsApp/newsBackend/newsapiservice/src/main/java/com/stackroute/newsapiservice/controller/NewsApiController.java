package com.stackroute.newsapiservice.controller;

import com.stackroute.newsapiservice.model.News;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping()
@CrossOrigin("*")
public class NewsApiController {
    private final Environment env;

    NewsApiController(Environment env) {
        this.env = env;
    }


    @GetMapping(value = "/")
    public String helloWorld(){
        return "Server is running";
    }

    @GetMapping(value = "/recomend")
    public ResponseEntity<News> getNewsRecomend(@RequestParam String category) {
        if(category.equals("all")) category="";
        String url="https://newsapi.org/v2/top-headlines?country=in&apiKey="+env.getProperty("NEWS_API_KEY")+"&category="+category;
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(url,News.class);
        return ResponseEntity.status(HttpStatus.OK).body(news);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<News> getNewsSearch(@RequestParam String q) {

        String url="https://newsapi.org/v2/everything?q="+q+"&sortBy=publishedAt&apiKey="+env.getProperty("NEWS_API_KEY")+"";
        RestTemplate restTemplate = new RestTemplate();
        News news = restTemplate.getForObject(url,News.class);
        return ResponseEntity.status(HttpStatus.OK).body(news);
    }


}
