package com.nicsern.PayFlow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicsern.PayFlow.dto.PaymentRequest;
import com.nicsern.PayFlow.entities.Transaction;
import com.nicsern.PayFlow.services.CheckoutService;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping("/process")
    public ResponseEntity<?> processCheckout(@RequestBody PaymentRequest request) {
    
        Transaction result = checkoutService.processCheckout(request);
        return ResponseEntity.ok(result);
    }
}

