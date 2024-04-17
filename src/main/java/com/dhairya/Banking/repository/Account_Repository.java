package com.dhairya.Banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dhairya.Banking.entity.Account;

public interface Account_Repository extends JpaRepository<Account,Long> {
}
