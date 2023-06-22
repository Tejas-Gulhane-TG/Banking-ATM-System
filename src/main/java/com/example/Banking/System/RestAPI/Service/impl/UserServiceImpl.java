package com.example.Banking.System.RestAPI.Service.impl;

import com.example.Banking.System.RestAPI.Dto.RequestDto.UserRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.UserResponseDto;
import com.example.Banking.System.RestAPI.Model.User;
import com.example.Banking.System.RestAPI.Repository.UserRepository;
import com.example.Banking.System.RestAPI.Service.UserService;
import com.example.Banking.System.RestAPI.Transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserResponseDto AddUser(UserRequestDto userRequestDto) {

        User user = UserTransformer.RequestDtoToUser(userRequestDto);
        userRepository.save(user);
        return UserTransformer.UserToResponseDto(user);

    }

    @Override
    public UserResponseDto GetUser(long mobileNo) {

        User user = userRepository.findByMobileNo(mobileNo);
        return UserTransformer.UserToResponseDto(user);

    }
}
