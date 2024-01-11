package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Transaction;
import com.solvd.laba.persistence.LoanRepository;
import com.solvd.laba.persistence.TransactionRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.Optional;

public class TransactionMyBatisDAO implements TransactionRepository {
    @Override
    public void create(Transaction transaction, Long customerId) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            TransactionRepository transactionRepository = sqlSession.getMapper(TransactionRepository.class);
            transactionRepository.create(transaction,customerId);
        }

    }

    @Override
    public Optional<Transaction> findById(Long id) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            TransactionRepository transactionRepository = sqlSession.getMapper(TransactionRepository.class);
            return transactionRepository.findById(id);
        }
    }

    @Override
    public void update(Transaction transaction) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            TransactionRepository transactionRepository = sqlSession.getMapper(TransactionRepository.class);
            transactionRepository.update(transaction);
        }
    }
}
