package com.nutritionist.favorite.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("datas")
public class Favourite {
    private  int id;
    private String foodIds;
    private String user_id;

    public Favourite(int id, String foodIds, String user_id) {
        this.id = id;
        this.foodIds = foodIds;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodIds() {
        return foodIds;
    }

    public void setFoodIds(String foodIds) {
        this.foodIds = foodIds;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
