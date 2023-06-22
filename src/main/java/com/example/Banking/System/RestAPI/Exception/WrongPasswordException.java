package com.example.Banking.System.RestAPI.Exception;

public class WrongPasswordException extends Exception{
    public WrongPasswordException (String Msg){
        super(Msg);
    }
}
