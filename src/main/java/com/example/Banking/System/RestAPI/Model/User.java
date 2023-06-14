package com.example.Banking.System.RestAPI.Model;

import com.example.Banking.System.RestAPI.Enum.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

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
    @Column(nullable = false, unique = true)
    String emailId;

    @Column(unique = true, nullable = true)
    long mobileNo;

    long accountNo=mobileNo;

    @Enumerated
    Gender gender;

    @Column(nullable = false)
    String address;

    @Column(nullable = false)
    String password;

}
