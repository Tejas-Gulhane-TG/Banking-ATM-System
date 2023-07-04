package com.example.Banking.System.RestAPI.Transformer;


import com.example.Banking.System.RestAPI.Dto.RequestDto.DepositRequestDto;
import com.example.Banking.System.RestAPI.Dto.RequestDto.WithdrawRequestDto;
import com.example.Banking.System.RestAPI.Enum.TransactionType;
import com.example.Banking.System.RestAPI.Model.Transaction;

public class TransactionTransformer {

    public static Transaction DepositDtoToTransaction(DepositRequestDto depositRequestDto){
        return Transaction.builder()
                .transactionType(TransactionType.DEPOSIT)
                .amount(depositRequestDto.getMoney())
                .build();
    }

    public static Transaction  WithdrawDtoToTransaction(WithdrawRequestDto withdrawRequestDto){
        return Transaction.builder()
                .amount(withdrawRequestDto.getMoney())
                .transactionType(TransactionType.WITHDRAW)
                .build();
    }
}
