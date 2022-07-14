package com.nutritionist.favorite.repository;

import com.nutritionist.favorite.domain.Favourite;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FavouriteRepository extends MongoRepository<Favourite, Integer> {

}
