package com.example.Banking.System.RestAPI.Service;

import com.example.Banking.System.RestAPI.Dto.RequestDto.TransactionRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.TransactionResponseDto;
import com.example.Banking.System.RestAPI.Exception.AccountNotFoundException;
import com.example.Banking.System.RestAPI.Exception.InsufficientBalanceException;
import com.example.Banking.System.RestAPI.Exception.TransactionTypeWrongException;
import com.example.Banking.System.RestAPI.Exception.WrongPasswordException;

public interface TransactionService {
    TransactionResponseDto Withdraw(TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException, InsufficientBalanceException, WrongPasswordException,AccountNotFoundException;

    TransactionResponseDto Deposit(TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException, AccountNotFoundException ;
}
