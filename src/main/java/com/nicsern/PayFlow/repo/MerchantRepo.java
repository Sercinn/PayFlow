package com.nicsern.PayFlow.repo;

import org.springframework.stereotype.Repository;

import com.nicsern.PayFlow.entities.Merchant;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface MerchantRepo extends JpaRepository<Merchant, Long> {
    Merchant findByEmail(String email);
}
