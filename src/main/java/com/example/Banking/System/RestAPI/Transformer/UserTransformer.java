package com.example.Banking.System.RestAPI.Transformer;

import com.example.Banking.System.RestAPI.Dto.RequestDto.UserRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.UserResponseDto;
import com.example.Banking.System.RestAPI.Model.User;

public class UserTransformer {

    public static User RequestDtoToUser(UserRequestDto userRequestDto){

        return User.builder()
                .name(userRequestDto.getName())
                .address(userRequestDto.getAddress())
                .gender(userRequestDto.getGender())
                .emailId(userRequestDto.getEmailId())
                .mobileNo(userRequestDto.getMobileNo())
                .accountNo(userRequestDto.getMobileNo())
                .accountType(userRequestDto.getAccountType())
                .balance(userRequestDto.getBalance())
                .pin(userRequestDto.getPin())
                .build();
    }

    public static UserResponseDto UserToResponseDto(User user){
        return UserResponseDto.builder()
                .Name(user.getName())
                .gender(user.getGender())
                .MobileNo(user.getMobileNo())
                .Address(user.getAddress())
                .EmailId(user.getEmailId())
                .AccountNo(user.getAccountNo())
                .accountType(user.getAccountType())
                .build();
    }
}
