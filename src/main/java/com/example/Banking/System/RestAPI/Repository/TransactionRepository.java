package com.example.Banking.System.RestAPI.Repository;

import com.example.Banking.System.RestAPI.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
