package com.musicapp.favoriteservice.controller;

//import com.nutritionist.favorite.domain.Favourite;
//import com.nutritionist.favorite.repository.FavouriteRepository;
//import com.nutritionist.favorite.service.DataService;
//import com.nutritionist.favorite.service.FavoriteService;
import com.musicapp.favoriteservice.domain.Favourite;
import com.musicapp.favoriteservice.domain.recomend.Data;
import com.musicapp.favoriteservice.repository.FavouriteRepository;
import com.musicapp.favoriteservice.service.DataService;
import com.musicapp.favoriteservice.service.FavoriteService;
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
            favIds+=favouriteObj.getmIds();
        }
        try{
            Data bookData;
            if(data.size()>0) {
                bookData = dataService.consumeApi("https://api.napster.com/v2.2/tracks/"+favIds+"?apikey=YTkxZTRhNzAtODdlNy00ZjMzLTg0MWItOTc0NmZmNjU4Yzk4");
            }else{
                bookData = null;
            }
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
            favIds+=favouriteObj.getmIds();
        }
        System.out.println(favIds);
        try{
            Data bookData;
            if(data.size()>0) {
                bookData = dataService.consumeApi("https://api.napster.com/v2.2/tracks/" + favIds + "?apikey=YTkxZTRhNzAtODdlNy00ZjMzLTg0MWItOTc0NmZmNjU4Yzk4");
            }else{
                bookData = null;
            }
            return  ResponseEntity.status(HttpStatus.OK).body(bookData);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }

}
