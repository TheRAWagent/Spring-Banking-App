package com.dhairya.Banking.service;

import java.util.List;
import com.dhairya.Banking.dto.Account_dto;

public interface Account_Service {
  Account_dto createAccount(Account_dto account);
  Account_dto getAccountById(Long id);
  Account_dto deposit(Long id, double amount);
  Account_dto withdraw(Long id, double amount);
  List<Account_dto> getAllAccounts();
  void deleteAccount(Long id);
}
