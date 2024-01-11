package com.solvd.laba.persistence;

import com.solvd.laba.domain.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountRepository {

    void create(@Param("account") Account account, @Param("customerID") Long customerID);
    List<Account> findBalanceBiggerThan(double amount);
    void update(Account account);

}
