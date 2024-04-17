package com.dhairya.Banking.mapper;

import com.dhairya.Banking.dto.Account_dto;
import com.dhairya.Banking.entity.Account;

public class Account_Mapper {
  public static Account mapToAccount(Account_dto account_dto) {
    Account account = new Account(
        account_dto.getId(),
        account_dto.getAccountHolderName(),
        account_dto.getBalance());
    return account;
  }

  public static Account_dto mapToAccount_dto(Account account) {
    Account_dto account_dto = new Account_dto(
        account.getId(),
        account.getAccountHolderName(),
        account.getBalance());
    return account_dto;
  }
}
