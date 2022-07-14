package com.nutritionist.api_control.controller;

import com.nutritionist.api_control.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
public class DataController {
    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value={"", "/recomended"})
    public ResponseEntity getRecomendedData() {
            var output = dataService.recomendConsumeApi("https://api.nal.usda.gov/fdc/v1/foods/list?dataType=Foundation,SR%20Legacy&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }

    @GetMapping(value = {"","/search"})
    public ResponseEntity getSearchedData(@RequestParam(value = "q") String q){
        var output = dataService.consumeApi("https://api.nal.usda.gov/fdc/v1/foods/search?query="+q+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
    return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
