package com.stackroute.newsapp.userservice.helper;

public class UserFoundException extends Exception{
    public UserFoundException(){
        super("User with this username is already their in DB!! Try with new username.");
    }
    public UserFoundException(String msg){
        super(msg);
    }
}
