package com.musicapp.favoriteservice.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("fav")
public class Favourite {
    private  int id;
    private String mIds;
    private String user_id;

    public Favourite(int id, String mIds, String user_id) {
        this.id = id;
        this.mIds = mIds;
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmIds() {
        return mIds;
    }

    public void setmIds(String mIds) {
        this.mIds = mIds;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
