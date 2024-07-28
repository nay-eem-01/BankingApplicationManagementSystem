package com.example.bankingapplicationmanagementsystem.repository;

import com.example.bankingapplicationmanagementsystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {

}
