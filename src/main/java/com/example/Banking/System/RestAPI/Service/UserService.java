package com.example.Banking.System.RestAPI.Service;

import com.example.Banking.System.RestAPI.Dto.RequestDto.UserRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.UserResponseDto;

public interface UserService {
    UserResponseDto AddUser(UserRequestDto userRequestDto);

    UserResponseDto GetUser(long mobileNo);
}
