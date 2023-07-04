package com.example.Banking.System.RestAPI.Service.impl;


import com.example.Banking.System.RestAPI.Dto.RequestDto.DepositRequestDto;
import com.example.Banking.System.RestAPI.Dto.RequestDto.WithdrawRequestDto;
import com.example.Banking.System.RestAPI.Enum.TransactionStatus;
import com.example.Banking.System.RestAPI.Model.Transaction;
import com.example.Banking.System.RestAPI.Model.User;
import com.example.Banking.System.RestAPI.Repository.TransactionRepository;
import com.example.Banking.System.RestAPI.Repository.UserRepository;
import com.example.Banking.System.RestAPI.Service.TransactionService;
import com.example.Banking.System.RestAPI.Transformer.TransactionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void DepositMoney(DepositRequestDto depositRequestDto) {
        User user = userRepository.findByAccountNo(depositRequestDto.getAccountNo());
        Transaction transaction = TransactionTransformer.DepositDtoToTransaction(depositRequestDto);
        transaction.setUser(user);
        user.setBalance(user.getBalance()+depositRequestDto.getMoney());
        List<Transaction> transactionList = user.getTransactionList();
        transactionList.add(transaction);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transaction);
        userRepository.save(user);
    }

    @Override
    public String WithdrawMoney(WithdrawRequestDto withdrawRequestDto) {
        User user = userRepository.findByAccountNo(withdrawRequestDto.getAccountNo());
        Transaction transaction = TransactionTransformer.WithdrawDtoToTransaction(withdrawRequestDto);
        transaction.setUser(user);
        if(user.getBalance() < withdrawRequestDto.getMoney()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            List<Transaction> transactionList = user.getTransactionList();
            transactionList.add(transaction);
            transactionRepository.save(transaction);
            userRepository.save(user);
            return "Insufficient Balance";
        }
        user.setBalance(user.getBalance()-withdrawRequestDto.getMoney());
        List<Transaction> transactionList = user.getTransactionList();
        transactionList.add(transaction);
        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transactionRepository.save(transaction);
        userRepository.save(user);
        return "Money Withdraw Success";
    }
}
