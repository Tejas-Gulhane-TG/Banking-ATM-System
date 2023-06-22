package com.example.Banking.System.RestAPI.Controller;

import com.example.Banking.System.RestAPI.Dto.RequestDto.UserRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.UserResponseDto;
import com.example.Banking.System.RestAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create-new")
    public ResponseEntity AddUser(@RequestBody UserRequestDto userRequestDto){

        UserResponseDto userResponseDto = userService.AddUser(userRequestDto);
        return new ResponseEntity(userResponseDto , HttpStatus.CREATED);

    }

    @GetMapping("/get-user-by-mobile-no/{mobileNo}")
    public ResponseEntity GetUser(@PathVariable long mobileNo){

        UserResponseDto userResponseDto = userService.GetUser(mobileNo);
        return new ResponseEntity(userResponseDto, HttpStatus.FOUND);
    }
}
