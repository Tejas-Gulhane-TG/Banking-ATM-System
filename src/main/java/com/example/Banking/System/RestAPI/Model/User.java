package com.example.Banking.System.RestAPI.Model;

import com.example.Banking.System.RestAPI.Enum.AccountType;
import com.example.Banking.System.RestAPI.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false, unique = true)
    String emailId;

    @Column(unique = true, nullable = true)
    long mobileNo;

    @Enumerated (EnumType.STRING)
    Gender gender;

    @Column(nullable = false)
    String address;

    @Column(unique = true)
    long accountNo;

    @Enumerated(EnumType.STRING)
    AccountType accountType;

    @Column(nullable = false)
    int pin;

    double balance;

    @CreationTimestamp
    Date dateOfCreation;

    @OneToMany(mappedBy = "user")
    List<Transaction> transactionList = new ArrayList<>();

}
