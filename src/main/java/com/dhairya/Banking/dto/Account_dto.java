package com.dhairya.Banking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account_dto {
  private Long id;
  private String accountHolderName;
  private double balance; 
}
