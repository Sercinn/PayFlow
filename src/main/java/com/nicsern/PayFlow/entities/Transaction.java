package com.nicsern.PayFlow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction {
    @Id @GeneratedValue
    private Long id;
    private String merchantId;
    private Double amount;
    private String customerEmail;
    private String customerName;
    private String status = "PENDING";
}
