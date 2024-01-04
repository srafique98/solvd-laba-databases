package com.solvd.laba.service;

import com.solvd.laba.domain.Transaction;

import java.util.Optional;

public interface TransactionService {
    void create(Transaction transaction, Long customerId);
    Optional<Transaction> retrieveById(Long id);
    void update(Transaction transaction);
}
