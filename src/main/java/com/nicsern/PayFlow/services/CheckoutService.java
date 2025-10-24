package com.nicsern.PayFlow.services;

import org.springframework.stereotype.Service;

import com.nicsern.PayFlow.dto.PaymentRequest;
import com.nicsern.PayFlow.entities.Transaction;
import com.nicsern.PayFlow.repo.TransactionRepo;

@Service
public class CheckoutService {

    private TransactionRepo tRepo;

    public CheckoutService(TransactionRepo tRepo) {
        this.tRepo = tRepo;
    }

    public Transaction processCheckout(PaymentRequest request) {
        // test for dummy payment card to indicate successful payment
        boolean success = request.getCardNumber().equals("4242424242424242") && request.getCardExpiryDate().equals("12/24") && request.getCardCVV().equals("123");

        Transaction t = new Transaction();
        t.setCustomerName(request.getCustomerName());
        t.setCustomerEmail(request.getCustomerEmail());
        t.setAmount(request.getAmount());
        t.setMerchantId(request.getMerchantId());
        t.setStatus(success ? "SUCCESS" : "FAILED");

        tRepo.save(t);

        // Optionally trigger merchant webhook (later step)
        // if (success) webhookService.sendNotification(tx);

        return t;
    }
}
