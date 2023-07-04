package com.example.Banking.System.RestAPI.Service;


import com.example.Banking.System.RestAPI.Dto.RequestDto.DepositRequestDto;
import com.example.Banking.System.RestAPI.Dto.RequestDto.WithdrawRequestDto;

public interface TransactionService {
    void DepositMoney(DepositRequestDto depositRequestDto);

    String WithdrawMoney(WithdrawRequestDto withdrawRequestDto);
}
