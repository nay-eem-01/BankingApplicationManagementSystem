package com.example.bankingapplicationmanagementsystem.controller;

import com.example.bankingapplicationmanagementsystem.dto.AccountDto;
import com.example.bankingapplicationmanagementsystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bank")

public class AccountController {
    private  final AccountService accountService;
    @Autowired
    AccountController(AccountService accountService){

        this.accountService=accountService;

    }

    @PostMapping ("/accounts")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<> (accountService.createAccount(accountDto), HttpStatus.CREATED);
    }
    @GetMapping("/accounts/{id}")
    public ResponseEntity<AccountDto> viewAccount(@PathVariable Long id){
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/accounts")
    public ResponseEntity <List<AccountDto>> viewAllAccount(){
        List<AccountDto> accountDtos = accountService.getAllAccount();
        return ResponseEntity.ok(accountDtos);
    }
    @PutMapping("/accounts/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){

        double amount= request.get("amount");
        AccountDto accountDto = accountService.deposit(id,amount);

       return ResponseEntity.ok(accountDto);
    }
    @PutMapping("/accounts/withdraw/{id}")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id, @RequestBody Map<String,Double> request){

        double amount= request.get("amount");
        AccountDto accountDto = accountService.withDraw(id,amount);

        return ResponseEntity.ok(accountDto);
    }
    @DeleteMapping("/accounts/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @PutMapping("/accounts/update/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable Long id , @RequestBody AccountDto accountDto){
        accountService.updateAccount(id,accountDto);

        return  ResponseEntity.ok(accountDto.getAccountHolderName());
    }


}
