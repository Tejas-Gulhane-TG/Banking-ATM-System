package com.example.Banking.System.RestAPI.Service.impl;

import com.example.Banking.System.RestAPI.Dto.RequestDto.TransactionRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.TransactionResponseDto;
import com.example.Banking.System.RestAPI.Enum.TransactionStatus;
import com.example.Banking.System.RestAPI.Enum.TransactionType;
import com.example.Banking.System.RestAPI.Exception.AccountNotFoundException;
import com.example.Banking.System.RestAPI.Exception.InsufficientBalanceException;
import com.example.Banking.System.RestAPI.Exception.TransactionTypeWrongException;
import com.example.Banking.System.RestAPI.Exception.WrongPasswordException;
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
    UserRepository userRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Override
    public TransactionResponseDto Withdraw(TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException,InsufficientBalanceException, WrongPasswordException, AccountNotFoundException {

        if(transactionRequestDto.getTransactionType() == TransactionType.WITHDRAW){
            Transaction transaction = TransactionTransformer.RequestDtoToTransaction(transactionRequestDto);
            User user = userRepository.findByMobileNo(transactionRequestDto.getAccountNo());

            if(user == null){
                throw new AccountNotFoundException("Account Number Not Found");
            }
            if(transaction.getPin() != user.getPin()){
                throw new WrongPasswordException("Wrong Password");
            }
            if(transaction.getAmount() > user.getBalance()){
                transaction.setTransactionStatus(TransactionStatus.FAILED);
                transaction.setUser(user);
                transactionRepository.save(transaction);
                throw new InsufficientBalanceException("Insufficient Balance");
            }

            user.setBalance(user.getBalance() - transaction.getAmount());
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction.setMainBalance(user.getBalance());
            List<Transaction> tempList = user.getTransactionList();
            tempList.add(transaction);
            user.setTransactionList(tempList);
            userRepository.save(user);
            transaction.setUser(user);
            transactionRepository.save(transaction);

            TransactionResponseDto transactionResponseDto = TransactionTransformer.TransactionToResponseDto(transaction);
            transactionResponseDto.setMSG("MONEY WITHDRAW SUCCESSFULLY");

            return transactionResponseDto;
        }
        throw new TransactionTypeWrongException("Transaction Type Wrong");
    }

    @Override
    public TransactionResponseDto Deposit(TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException ,AccountNotFoundException {

        if(transactionRequestDto.getTransactionType() == TransactionType.DEPOSIT){
            Transaction transaction = TransactionTransformer.RequestDtoToTransaction(transactionRequestDto);
            User user = userRepository.findByMobileNo(transactionRequestDto.getAccountNo());

            if(user == null){
                throw new AccountNotFoundException("Account Number Not Found");
            }

            user.setBalance(user.getBalance() + transaction.getAmount());
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            transaction.setMainBalance(user.getBalance());
            List<Transaction> tempList = user.getTransactionList();
            tempList.add(transaction);
            user.setTransactionList(tempList);
            userRepository.save(user);
            transaction.setUser(user);
            transactionRepository.save(transaction);

            TransactionResponseDto transactionResponseDto = TransactionTransformer.TransactionToResponseDto(transaction);
            transactionResponseDto.setMSG("MONEY DEPOSIT SUCCESSFULLY");

            return transactionResponseDto;
        }
        throw new TransactionTypeWrongException("Wrong Transaction Type");
    }
}


