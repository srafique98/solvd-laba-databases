package com.solvd.laba.persistence;

import com.solvd.laba.domain.Customer;
import com.solvd.laba.domain.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

public interface TransactionRepository {

    void create(@Param("transaction") Transaction transaction, @Param("customerId") Long customerId);
    Optional<Transaction> findById(Long id);
    void update(Transaction transaction);
}
