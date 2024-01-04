package com.solvd.laba.persistence;

import com.solvd.laba.domain.Account;
import java.util.List;

public interface AccountRepository {

    void create(Account account, Long customerID);
    List<Account> findBalanceBiggerThan(double amount);
    void update(Account account);

}
