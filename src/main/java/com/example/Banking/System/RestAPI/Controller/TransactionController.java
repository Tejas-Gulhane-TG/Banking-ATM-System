package com.example.Banking.System.RestAPI.Controller;

import com.example.Banking.System.RestAPI.Dto.RequestDto.DepositRequestDto;
import com.example.Banking.System.RestAPI.Dto.RequestDto.WithdrawRequestDto;
import com.example.Banking.System.RestAPI.Model.User;
import com.example.Banking.System.RestAPI.Service.TransactionService;
import com.example.Banking.System.RestAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TransactionController {

    @Autowired
    UserService userService;

    @Autowired
    TransactionService transactionService;

    @GetMapping("/deposit")
    public String Deposit(){
        return "deposit";
    }

    @GetMapping("/depositMoney")
    public String Deposit(@ModelAttribute DepositRequestDto depositRequestDto, Model model){

        User user = userService.GetUser(depositRequestDto.getAccountNo());
        if(user==null){
            model.addAttribute("Massage", "Account Not Found");
            return "massage";
        }
        transactionService.DepositMoney(depositRequestDto);

        model.addAttribute("Massage", "Money Added Successfully");
        model.addAttribute("Name", user.getName());
        model.addAttribute("Account", user.getAccountNo());
        model.addAttribute("Amount", depositRequestDto.getMoney());
        return "massage";
    }

    @GetMapping("/withdrawMoney")
    public String WithdrawMoney(@ModelAttribute WithdrawRequestDto withdrawRequestDto, Model model){

        User user = userService.GetUser(withdrawRequestDto.getAccountNo());
        if(user == null){
            model.addAttribute("Massage", "Account Not Found");
            return "massage";
        }
        if(user.getPin() != withdrawRequestDto.getPin()){
            model.addAttribute("Massage", "Wrong PIN");
            return "massage";
        }
        String msg = transactionService.WithdrawMoney(withdrawRequestDto);
        model.addAttribute("Massage", msg);
        model.addAttribute("Name", user.getName());
        model.addAttribute("Account", user.getAccountNo());
        model.addAttribute("Amount", withdrawRequestDto.getMoney());
        return "massage";

    }

}
