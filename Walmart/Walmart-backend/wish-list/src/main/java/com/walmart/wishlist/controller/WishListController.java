package com.walmart.wishlist.controller;

import com.walmart.wishlist.domain.WishList;
import com.walmart.wishlist.repo.WishListRepo;
import com.walmart.wishlist.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/wish-list")
public class WishListController {
    private WishListRepo wishListRepo;
    private WishListService wishListService;
    @Autowired
    public WishListController(WishListRepo wishListRepo, WishListService wishListService) {
        this.wishListRepo = wishListRepo;
        this.wishListService = wishListService;
    }

    @PostMapping(value = {"","/add"})
    public ResponseEntity addFavourite(@RequestBody WishList wishList){
        WishList save =  this.wishListRepo.save(wishList);
        return ResponseEntity.status(HttpStatus.OK).body(save);
    }

    @GetMapping(value = {"","/user"})
    public ResponseEntity getFavouriteUserWish(@RequestParam String id){
        try{
            var data = this.wishListService.userWishLists(id);
            System.out.println(data);
            return ResponseEntity.status(HttpStatus.OK).body(data);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }

    }
    @GetMapping(value = {"","/all"})
    public ResponseEntity getFavourits(){
        var data = this.wishListRepo.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping(value = {"","/del"})
    public ResponseEntity<?> delFavourite(@RequestParam Integer id,  @RequestParam String userId){
        this.wishListRepo.deleteById(id);
        var data = this.wishListService.userWishLists(userId);
        return ResponseEntity.status(HttpStatus.OK).body(data);

    }
}
