package com.stackroute.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.domain.News;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface NewsRepository extends MongoRepository<News, String>
{
    List<News> findByUserId(String userId);

    Optional<News> findByUserIdAndTitle(String userId, String title);
}
