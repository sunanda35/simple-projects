package com.musicapp.favoriteservice.repository;

import com.musicapp.favoriteservice.domain.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavouriteRepository extends MongoRepository<Favourite, Integer> {

}
