package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Account;
import com.solvd.laba.persistence.AccountRepository;
import com.solvd.laba.persistence.impl.AccountDAO;
import com.solvd.laba.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    public AccountServiceImpl() {
        this.accountRepository = new AccountDAO();
    }

    @Override
    public void create(Account account, Long customerID) {
        accountRepository.create(account,customerID);
    }

    @Override
    public List<Account> retrieveBalance(double amount) {
        return accountRepository.findBalanceBiggerThan(amount);
    }

    @Override
    public void update(Account account) {
        accountRepository.update(account);
    }
}
