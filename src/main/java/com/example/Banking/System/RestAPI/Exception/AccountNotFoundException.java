package com.example.Banking.System.RestAPI.Exception;

public class AccountNotFoundException extends Exception{
    public AccountNotFoundException (String msg){
        super(msg);
    }
}
