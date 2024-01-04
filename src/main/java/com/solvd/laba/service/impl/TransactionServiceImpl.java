package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Transaction;
import com.solvd.laba.persistence.TransactionRepository;
import com.solvd.laba.persistence.impl.TransactionDAO;
import com.solvd.laba.service.TransactionService;

import java.util.Optional;

public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl( ) {
        this.transactionRepository = new TransactionDAO();
    }

    @Override
    public void create(Transaction transaction, Long customerId) {
        transactionRepository.create(transaction,customerId);
    }

    @Override
    public Optional<Transaction> retrieveById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void update(Transaction transaction) {
        transactionRepository.update(transaction);
    }
}
