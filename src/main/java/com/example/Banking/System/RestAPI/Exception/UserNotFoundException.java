package com.example.Banking.System.RestAPI.Exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String msg){
        super(msg);
    }
}
