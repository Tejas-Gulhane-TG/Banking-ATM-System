package com.example.Banking.System.RestAPI.Model;

import com.example.Banking.System.RestAPI.Enum.AccountType;
import com.example.Banking.System.RestAPI.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(unique = true, nullable = false)
    String email;

    int pin;

    double balance;

    long accountNo;

    String address;

    @Column(unique = true, nullable = false)
    long mobileNo;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @OneToMany (mappedBy = "user")
    List<Transaction> transactionList = new ArrayList<>();


}
