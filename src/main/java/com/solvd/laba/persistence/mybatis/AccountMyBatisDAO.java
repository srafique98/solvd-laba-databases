package com.solvd.laba.persistence.mybatis;

import com.solvd.laba.domain.Account;
import com.solvd.laba.persistence.AccountRepository;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AccountMyBatisDAO implements AccountRepository {
    @Override
    public void create(Account account, Long customerID) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
            accountRepository.create(account,customerID);
        }
    }

    @Override
    public List<Account> findBalanceBiggerThan(double amount) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
            return accountRepository.findBalanceBiggerThan(amount);
        }
    }

    @Override
    public void update(Account account) {
        try (SqlSession sqlSession = PersistenceConfig.getSessionFactory().openSession(true)){
            AccountRepository accountRepository = sqlSession.getMapper(AccountRepository.class);
            accountRepository.update(account);
        }

    }
}
