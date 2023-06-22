package com.example.Banking.System.RestAPI.Exception;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String Msg){
        super(Msg);
    }
}
