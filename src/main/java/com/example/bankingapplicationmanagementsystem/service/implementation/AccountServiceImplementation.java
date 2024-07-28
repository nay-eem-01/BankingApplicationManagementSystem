package com.example.bankingapplicationmanagementsystem.service.implementation;

import com.example.bankingapplicationmanagementsystem.dto.AccountDto;
import com.example.bankingapplicationmanagementsystem.entity.Account;
import com.example.bankingapplicationmanagementsystem.mapper.AccountMapper;
import com.example.bankingapplicationmanagementsystem.repository.AccountRepository;
import com.example.bankingapplicationmanagementsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Component
public  class AccountServiceImplementation implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    AccountServiceImplementation(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        Account account = AccountMapper.maptoAccount(accountDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
     Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public List <AccountDto> getAllAccount() {
       List<Account> accounts = accountRepository.findAll();
       List<AccountDto> accountDtos = new ArrayList<>();
       for(Account account : accounts){
           AccountDto accountDto = AccountMapper.maptoAccountDto(account);
           accountDtos.add(accountDto);
       }

        return accountDtos;
    }

    @Override
    public AccountDto deposit(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

       double total = account.getBalance()+amount;
       account.setBalance(total);
       accountRepository.save(account);

        return AccountMapper.maptoAccountDto(account);
    }
    public AccountDto withDraw(Long id, Double amount) {

        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));

       if (account.getBalance()>=amount){
           double total = account.getBalance()-amount;
           account.setBalance(total);
           accountRepository.save(account);
       }
       else {
           throw new RuntimeException("Insufficient Balance") ;
       }

        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        accountRepository.deleteById(id);

    }

    @Override
    public AccountDto updateAccount(Long id, AccountDto accountDto) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
        account.setAccountHolderName(accountDto.getAccountHolderName());
        accountRepository.save(account);
        return AccountMapper.maptoAccountDto(account);
    }
}
