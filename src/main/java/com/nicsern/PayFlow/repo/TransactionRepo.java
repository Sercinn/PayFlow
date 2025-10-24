package com.nicsern.PayFlow.repo;

import org.springframework.stereotype.Repository;

import com.nicsern.PayFlow.entities.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    // Find all transactions by merchant ID
    List<Transaction> findByMerchantId(String merchantId);

}


