package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.Transaction;

import java.util.Optional;

public interface TransactionRepository {

    void create(Transaction transaction, Long customerId);
    Optional<Transaction> findById(Long id);
    void update(Transaction transaction);
}
