package com.example.Banking.System.RestAPI.Controller;

import com.example.Banking.System.RestAPI.Dto.RequestDto.WithdrawRequestDto;
import com.example.Banking.System.RestAPI.Model.Transaction;
import com.example.Banking.System.RestAPI.Model.User;
import com.example.Banking.System.RestAPI.Repository.UserRepository;
import com.example.Banking.System.RestAPI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/")
    public String Index(){
        return "index";
    }

    @GetMapping("/create")
    public String Create(){
        return "create";
    }

//    @GetMapping("/deposit")
//    public String Deposit(){
//        return "deposit";
//    }

    @GetMapping("/withdraw")
    public String Withdraw(){
        return "withdraw";
    }

    @GetMapping("/transaction")
    public String Transaction(){
        return "transaction";
    }

    @GetMapping("/get")
    public String GetUser(){
        return "getUser";
    }

    @PostMapping("/addUser")
    public String AddUser(@ModelAttribute User user, Model model){
        userService.AddUser(user);
        model.addAttribute("Name", user.getName());
        model.addAttribute("AccountNo", user.getMobileNo());
        model.addAttribute("Massage", "Account Create Successfully");
        model.addAttribute("AccountType", user.getAccountType());
        return "UserInfo";
    }

    @GetMapping("/getUser")
    public String GetUser(@RequestParam long accountNo, Model model){
        User user = userService.GetUser(accountNo);
        if(user==null){
            model.addAttribute("Massage", "Account Not Found");
            return "UserInfo";
        }
        model.addAttribute("Name", user.getName());
        model.addAttribute("AccountNo", user.getMobileNo());
        model.addAttribute("Massage", "ACCOUNT INFORMATION");
        model.addAttribute("AccountType", user.getAccountType());
        return "UserInfo";
    }

    @GetMapping("/transactions")
    public String Transactions(@ModelAttribute WithdrawRequestDto withdrawRequestDto, Model model){
        User user = userService.GetUser(withdrawRequestDto.getAccountNo());
        if(user == null){
            model.addAttribute("Massage", "Account Not Found");
            return "massage";
        }
        if(user.getPin() != withdrawRequestDto.getPin()){
            model.addAttribute("Massage", "Wrong PIN");
            return "massage";
        }
        List<Transaction> Transactionlist = user.getTransactionList();
        model.addAttribute("Massage", "Transaction List are following");
        model.addAttribute("Name", user.getName());
        model.addAttribute("Account", user.getAccountNo());
        model.addAttribute("Lists", Transactionlist);
        return "massage";
    }

}
