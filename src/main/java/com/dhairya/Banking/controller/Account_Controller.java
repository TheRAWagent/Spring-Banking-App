package com.dhairya.Banking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhairya.Banking.dto.Account_dto;
import com.dhairya.Banking.service.Account_Service;

@RestController
@RequestMapping("/api/accounts")
public class Account_Controller {
  private Account_Service accountService;

  @Autowired
  public Account_Controller(Account_Service accountService) {
    this.accountService = accountService;
  }

  @PostMapping
  public ResponseEntity<Account_dto> accAccount(@RequestBody Account_dto accountDto){
    return new ResponseEntity<Account_dto>(accountService.createAccount(accountDto), HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Account_dto> getAccountById(@PathVariable Long id){
    Account_dto accountInfo = accountService.getAccountById(id);
    return ResponseEntity.ok(accountInfo);
  }

  @PutMapping("/{id}/deposit")
  public ResponseEntity<Account_dto> deposit(@PathVariable Long id, @RequestBody Map<String,Double> request){
    Account_dto accountInfo = accountService.deposit(id, request.get("amount"));
    return ResponseEntity.ok(accountInfo);
  }
  
  @PutMapping("/{id}/withdraw")
  public ResponseEntity<Account_dto> withdraw(@PathVariable Long id, @RequestBody Map<String,Double> request){
    Account_dto accountInfo = accountService.withdraw(id, request.get("amount"));
    return ResponseEntity.ok(accountInfo);
  }

  @GetMapping("/all")
  public ResponseEntity<List<Account_dto>> getAllAccounts(){
    return ResponseEntity.ok(accountService.getAllAccounts());
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> deleteAccount(@PathVariable Long id){
    accountService.deleteAccount(id);
    return ResponseEntity.ok("Account deleted successfully");
  }

}
