package com.example.Banking.System.RestAPI.Service;


import com.example.Banking.System.RestAPI.Model.User;

public interface UserService {
    void AddUser(User user);

    User GetUser(long accountNo);
}
