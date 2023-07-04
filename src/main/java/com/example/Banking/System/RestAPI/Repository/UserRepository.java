package com.example.Banking.System.RestAPI.Repository;

import com.example.Banking.System.RestAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByAccountNo(long accountNo);

}
