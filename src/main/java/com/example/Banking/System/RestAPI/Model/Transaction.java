package com.example.Banking.System.RestAPI.Model;

import com.example.Banking.System.RestAPI.Enum.TransactionStatus;
import com.example.Banking.System.RestAPI.Enum.TransactionType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CurrentTimestamp;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    long accountNo;

    int pin;

    double amount;

    double mainBalance;

    @CurrentTimestamp
    Date dateOfTransaction;

    @Enumerated(EnumType.STRING)
    TransactionType transactionType;

    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @ManyToOne
    @JoinColumn(referencedColumnName = "accountNo")
    User user;

}
