package com.example.Banking.System.RestAPI.Dto.ResponseDto;

import com.example.Banking.System.RestAPI.Enum.TransactionStatus;
import com.example.Banking.System.RestAPI.Enum.TransactionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class TransactionResponseDto {

    String MSG;
    TransactionStatus transactionStatus;
    TransactionType transactionType;
    long AccountNo;

    double Amount;
    double balance;
}
