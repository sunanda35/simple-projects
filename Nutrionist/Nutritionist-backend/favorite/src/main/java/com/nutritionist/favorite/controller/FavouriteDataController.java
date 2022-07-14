package com.nutritionist.favorite.controller;

import com.nutritionist.favorite.domain.Favourite;
import com.nutritionist.favorite.repository.FavouriteRepository;
import com.nutritionist.favorite.service.DataService;
import com.nutritionist.favorite.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/data/favourite")
public class FavouriteDataController {

    @Autowired
    private FavouriteRepository favouriteRepository;
    @Autowired
    private DataService dataService;

    @Autowired
    private FavoriteService favoriteService;


    @PostMapping(value = {"","/set"})
    public ResponseEntity addFavourite(@RequestBody Favourite favourite){
    Favourite save =  this.favouriteRepository.save(favourite);
    return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @GetMapping(value = {"","/"})
    public ResponseEntity getFavourite(@RequestParam String id){
        var favIds = "";
        var data = this.favoriteService.userWishLists(id);
        for (Favourite favouriteObj : data) {
            if(favIds!=""){
                favIds+=",";
            }
            favIds+=favouriteObj.getFoodIds();
        }
        try{
            var bookData = dataService.favConsumeApi("https://api.nal.usda.gov/fdc/v1/foods?fdcIds="+favIds+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
            return  ResponseEntity.status(HttpStatus.OK).body(bookData);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }


    @DeleteMapping(value = {"","/del"})
    public ResponseEntity<?> delFavourite(@RequestParam(value = "id") Integer _id){
        this.favouriteRepository.deleteById(_id);
        var favIds = "";
        var data = this.favouriteRepository.findAll();
        for (Favourite favouriteObj : data) {
            if(favIds!=""){
                favIds+=",";
            }
            favIds+=favouriteObj.getFoodIds();
        }
        try{
            var bookData = dataService.favConsumeApi("https://api.nal.usda.gov/fdc/v1/foods?fdcIds="+favIds+"&api_key=qqgiaSPX1eVDkb7mkUg3kSmptZZA1RZGphyVHQhh");
            return  ResponseEntity.status(HttpStatus.OK).body(bookData);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

}
