package com.nicsern.PayFlow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicsern.PayFlow.dto.LoginRequest;
import com.nicsern.PayFlow.dto.RegisterRequest;
import com.nicsern.PayFlow.entities.Merchant;
import com.nicsern.PayFlow.services.RegistrationService;

@RestController
@RequestMapping("/api/merchants")
public class MerchantController {

    private RegistrationService registrationService;

    public MerchantController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> processLogin(@RequestBody LoginRequest request) {
    
        Merchant result = registrationService.processLogin(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<?> processRegister(@RequestBody RegisterRequest request) {
    
        Merchant result = registrationService.processRegister(request);
        return ResponseEntity.ok(result);
    }
}
