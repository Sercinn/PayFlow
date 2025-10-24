package com.nicsern.PayFlow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Merchant {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String email;
    private String password;
    private String apiKey;
    private String webhookUrl;
}
