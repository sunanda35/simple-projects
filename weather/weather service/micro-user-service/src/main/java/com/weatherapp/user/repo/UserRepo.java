package com.weatherapp.user.repo;

import com.weatherapp.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<UserEntity, Long> {

    @Modifying
    @Query("UPDATE UserEntity SET firstName = :firstName,lastName=:lastName,phone=:phone WHERE id = :id")
    void updateUser(String firstName, String lastName,String phone,int id);

    @Modifying
    @Query("UPDATE UserEntity SET password = :password WHERE id = :id")
    void updatePassword(String password,Integer id);
}
