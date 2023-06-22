package com.example.Banking.System.RestAPI.Dto.ResponseDto;

import com.example.Banking.System.RestAPI.Enum.AccountType;
import com.example.Banking.System.RestAPI.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserResponseDto {

    String Name;
    long MobileNo;
    Gender gender;
    String Address;
    String EmailId;
    AccountType accountType;
    long AccountNo;

}
