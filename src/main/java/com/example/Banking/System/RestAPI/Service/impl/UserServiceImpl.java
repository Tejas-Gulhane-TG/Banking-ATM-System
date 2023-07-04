package com.example.Banking.System.RestAPI.Service.impl;

import com.example.Banking.System.RestAPI.Model.User;
import com.example.Banking.System.RestAPI.Repository.UserRepository;
import com.example.Banking.System.RestAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void AddUser(User user) {
        user.setAccountNo(user.getMobileNo());
        userRepository.save(user);
    }

    @Override
    public User GetUser(long accountNo) {
        User user = userRepository.findByAccountNo(accountNo);
        return user;
    }
}
