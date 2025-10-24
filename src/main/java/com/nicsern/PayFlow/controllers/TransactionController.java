package com.nicsern.PayFlow.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicsern.PayFlow.entities.Transaction;
import com.nicsern.PayFlow.repo.TransactionRepo;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepo tRepo;

    public TransactionController(TransactionRepo tRepo) {
        this.tRepo = tRepo;
    }

    // get all transactions
    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = tRepo.findAll();
        return ResponseEntity.ok(transactions);
    }

    // get all transactions for merchant
    @GetMapping("/merchant/{merchantId}")
    public ResponseEntity<List<Transaction>> getByMerchant(@PathVariable String merchantId) {
        List<Transaction> transactions = tRepo.findByMerchantId(merchantId);
        return ResponseEntity.ok(transactions);
    }
}
