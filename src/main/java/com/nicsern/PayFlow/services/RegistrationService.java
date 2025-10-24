package com.nicsern.PayFlow.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.nicsern.PayFlow.dto.LoginRequest;
import com.nicsern.PayFlow.dto.RegisterRequest;
import com.nicsern.PayFlow.entities.Merchant;
import com.nicsern.PayFlow.repo.MerchantRepo;

@Service
public class RegistrationService {

    private MerchantRepo mRepo;

    public RegistrationService(MerchantRepo mRepo) {
        this.mRepo = mRepo;
    }

    public Merchant processRegister(RegisterRequest request) {
        Merchant m = new Merchant();

        if (mRepo.findByEmail(request.getEmail()) != null) {
            throw new RuntimeException("Merchant already exists with this email");
        }

        // password 1 and 2 should be equal
        if (request.getPassword().equals(request.getPassword2())) {
            m.setUsername(request.getUsername());
            m.setEmail(request.getEmail());
            m.setPassword(request.getPassword());
            m.setApiKey(UUID.randomUUID().toString());
            mRepo.save(m);
            return m;
        } else {
            throw new RuntimeException("Passwords don't match");
        }
    }

    public Merchant processLogin(LoginRequest request) {
        Merchant m = mRepo.findByEmail(request.getEmail());
        if (m == null || !m.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }
        return m;
    }
}
