package com.nicsern.PayFlow.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PaymentRequest {
    private String customerName;
    private String customerEmail;
    private String cardNumber;
    private String cardExpiryDate;
    private String cardCVV;
    private Double amount;
    private String merchantId;
}
