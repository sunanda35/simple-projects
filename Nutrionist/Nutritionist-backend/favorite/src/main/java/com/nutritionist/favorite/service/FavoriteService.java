package com.nutritionist.favorite.service;

import com.nutritionist.favorite.domain.Favourite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public FavoriteService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Favourite> userWishLists(String userId){
        Query query = new Query().addCriteria(Criteria.where("user_id").is(userId));
        return mongoTemplate.find(query, Favourite.class);
    }
}
