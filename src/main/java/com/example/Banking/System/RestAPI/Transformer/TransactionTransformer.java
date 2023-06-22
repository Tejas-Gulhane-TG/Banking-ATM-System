package com.example.Banking.System.RestAPI.Transformer;

import com.example.Banking.System.RestAPI.Dto.RequestDto.TransactionRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.TransactionResponseDto;
import com.example.Banking.System.RestAPI.Model.Transaction;

public class TransactionTransformer {

    public static Transaction RequestDtoToTransaction(TransactionRequestDto transactionRequestDto){
        return Transaction.builder()
                .transactionType(transactionRequestDto.getTransactionType())
                .accountNo(transactionRequestDto.getAccountNo())
                .amount(transactionRequestDto.getAmount())
                .pin(transactionRequestDto.getPin())
                .build();
    }

    public static TransactionResponseDto TransactionToResponseDto(Transaction transaction){
        return TransactionResponseDto.builder()
                .transactionStatus(transaction.getTransactionStatus())
                .balance(transaction.getMainBalance())
                .AccountNo(transaction.getAccountNo())
                .transactionType(transaction.getTransactionType())
                .Amount(transaction.getAmount())
                .build();
    }
}
