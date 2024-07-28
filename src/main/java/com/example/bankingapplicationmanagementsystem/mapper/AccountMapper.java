package com.example.bankingapplicationmanagementsystem.mapper;

import com.example.bankingapplicationmanagementsystem.dto.AccountDto;
import com.example.bankingapplicationmanagementsystem.entity.Account;

public class AccountMapper {
    public static Account maptoAccount(AccountDto accountDto){

                return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );

    }
    public  static AccountDto maptoAccountDto(Account account){

                return  new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance())
                ;

    }
}
