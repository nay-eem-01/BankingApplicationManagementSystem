package com.example.bankingapplicationmanagementsystem.service;

import com.example.bankingapplicationmanagementsystem.dto.AccountDto;


import java.util.List;


public interface AccountService {
  AccountDto createAccount(AccountDto accountDto);
  AccountDto getAccountById(Long id);
   List <AccountDto> getAllAccount();
   AccountDto deposit(Long id, Double amount);
  AccountDto withDraw(Long id, Double amount);
  void deleteAccount(Long id);
  AccountDto updateAccount(Long id, AccountDto accountDto);
}
