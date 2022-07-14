package com.weatherapp.user.repo;


import com.weatherapp.user.entity.WishListEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface WishListRepo extends JpaRepository<WishListEntity, Integer> {

    @Query("from  WishListEntity where userId = :userId")
    Slice<WishListEntity> getWishList(Integer userId, Pageable pageable);

    @Query("from  WishListEntity where lower(city) = :city and userId=:userId")
    WishListEntity findWishListByCityAndId(String city,Integer userId);

    @Modifying
    @Query("delete from  WishListEntity where  id = :id and userId=:userId")
    void deleteByWisListIdAndUserId(Integer id ,Integer userId);
}
