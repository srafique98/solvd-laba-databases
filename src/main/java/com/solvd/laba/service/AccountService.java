package com.solvd.laba.service;

import com.solvd.laba.domain.Account;

import java.util.List;

public interface AccountService {
    void create(Account account, Long customerID);
    List<Account> retrieveBalance(double amount);
    void update(Account account);
}
