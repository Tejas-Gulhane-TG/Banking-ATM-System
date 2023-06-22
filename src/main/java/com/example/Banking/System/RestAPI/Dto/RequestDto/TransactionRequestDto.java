package com.example.Banking.System.RestAPI.Dto.RequestDto;

import com.example.Banking.System.RestAPI.Enum.TransactionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionRequestDto {

    long accountNo;

    double amount;

    int pin;

    TransactionType transactionType;
}
