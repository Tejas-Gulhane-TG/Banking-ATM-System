package com.example.Banking.System.RestAPI.Dto.RequestDto;

import com.example.Banking.System.RestAPI.Enum.AccountType;
import com.example.Banking.System.RestAPI.Enum.Gender;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {

    String name;

    String emailId;

    long mobileNo;

    Gender gender;

    String address;

    AccountType accountType;

    int pin;

    double balance;

}
