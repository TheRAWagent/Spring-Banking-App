package com.dhairya.Banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhairya.Banking.dto.Account_dto;
import com.dhairya.Banking.entity.Account;
import com.dhairya.Banking.mapper.Account_Mapper;
import com.dhairya.Banking.repository.Account_Repository;
import com.dhairya.Banking.service.Account_Service;

@Service
public class Account_Service_IMPL implements Account_Service {

  private Account_Repository accountRepository;

  @Autowired
  public Account_Service_IMPL(Account_Repository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Account_dto createAccount(Account_dto accountDto) {
    Account account = Account_Mapper.mapToAccount(accountDto);
    Account savedAccount = accountRepository.save(account);
    return Account_Mapper.mapToAccount_dto(savedAccount);
  }

  @Override
  public Account_dto getAccountById(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
    return Account_Mapper.mapToAccount_dto(account);
  }

  @Override
  public Account_dto deposit(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
    double totol = account.getBalance() + amount;
    account.setBalance(totol);
    Account updatedAccount = accountRepository.save(account);
    return Account_Mapper.mapToAccount_dto(updatedAccount);
  }

  @Override
  public Account_dto withdraw(Long id, double amount) {
    Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
    if(amount > account.getBalance()) {
      throw new RuntimeException("Insufficient balance");
    }
    double totol = account.getBalance() - amount;
    account.setBalance(totol);
    Account updatedAccount = accountRepository.save(account);
    return Account_Mapper.mapToAccount_dto(updatedAccount);
  }

  @Override
  public List<Account_dto> getAllAccounts() {
    List<Account> accounts = accountRepository.findAll();
    return accounts.stream().map(Account_Mapper::mapToAccount_dto).collect(Collectors.toList());
  }

  @Override
  public void deleteAccount(Long id) {
    Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
    accountRepository.delete(account);
  }
}
