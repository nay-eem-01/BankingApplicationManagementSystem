package com.example.bankingapplicationmanagementsystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account {
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;

   private String AccountHolderName;
   private Double balance;
}
