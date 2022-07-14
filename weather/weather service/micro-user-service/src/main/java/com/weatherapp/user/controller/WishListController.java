package com.weatherapp.user.controller;

import com.weatherapp.user.common.messages.BaseResponse;
import com.weatherapp.user.dto.UserDTO;
import com.weatherapp.user.dto.WishListDTO;
import com.weatherapp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wishlist")
public class WishListController {

    @Autowired
    UserService userService;

    @PostMapping(value = { "/add" })
    public ResponseEntity<BaseResponse> createWishList(@Valid @RequestBody WishListDTO wishListDTO) {
        BaseResponse response = userService.createWishList(wishListDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(value = { "/delete" })
    public ResponseEntity<BaseResponse> deleteWishList(@Valid @RequestParam int id,@RequestParam int userId) {
        BaseResponse response = userService.deleteWishList(id,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = { "/getAll" })
    public ResponseEntity<List<WishListDTO>> getWishListById(@Valid @RequestParam int userId) {
        List<WishListDTO> response = userService.getWishList(userId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
