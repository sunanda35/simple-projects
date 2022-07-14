package com.walmart.wishlist.repo;

import com.walmart.wishlist.domain.WishList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WishListRepo extends MongoRepository<WishList, Integer> {
}
