package com.example.Banking.System.RestAPI.Controller;

import com.example.Banking.System.RestAPI.Dto.RequestDto.TransactionRequestDto;
import com.example.Banking.System.RestAPI.Dto.ResponseDto.TransactionResponseDto;
import com.example.Banking.System.RestAPI.Exception.AccountNotFoundException;
import com.example.Banking.System.RestAPI.Exception.InsufficientBalanceException;
import com.example.Banking.System.RestAPI.Exception.TransactionTypeWrongException;
import com.example.Banking.System.RestAPI.Exception.WrongPasswordException;
import com.example.Banking.System.RestAPI.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/withdraw")
    public ResponseEntity Withdraw(@RequestBody TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException, InsufficientBalanceException, WrongPasswordException, AccountNotFoundException {
        try{
            TransactionResponseDto transactionResponseDto = transactionService.Withdraw(transactionRequestDto);
            return new ResponseEntity(transactionResponseDto, HttpStatus.ACCEPTED);
        }
        catch (AccountNotFoundException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        catch (WrongPasswordException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        catch (InsufficientBalanceException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (TransactionTypeWrongException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/deposit")
    public ResponseEntity Deposit(@RequestBody TransactionRequestDto transactionRequestDto) throws TransactionTypeWrongException, AccountNotFoundException{
       try{
           TransactionResponseDto transactionResponseDto = transactionService.Deposit(transactionRequestDto);
           return new ResponseEntity(transactionResponseDto, HttpStatus.ACCEPTED);
       }
       catch (AccountNotFoundException e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
       catch (TransactionTypeWrongException e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }
    }

}
