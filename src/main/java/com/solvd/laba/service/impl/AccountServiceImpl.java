package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Account;
import com.solvd.laba.persistence.AccountRepository;
import com.solvd.laba.persistence.impl.AccountDAO;
import com.solvd.laba.persistence.impl.LoanDAO;
import com.solvd.laba.persistence.mybatis.AccountMyBatisDAO;
import com.solvd.laba.service.AccountService;
import com.solvd.laba.service.StatementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private static final Logger LOGGER = LogManager.getLogger(AccountServiceImpl.class);
    private final AccountRepository accountRepository;
    private final StatementService statementService;

    public AccountServiceImpl() {
//        this.accountRepository = new AccountDAO();
        this.accountRepository = new AccountMyBatisDAO();

        this.statementService = new StatementServiceImpl();
    }

    @Override
    public void create(Account account, Long customerID) {
        LOGGER.info("Creating account");
        accountRepository.create(account,customerID);

        if (account.getStatements() != null  && !account.getStatements().isEmpty()) {
            LOGGER.info("Statements to be created");
            account.getStatements().forEach(statement -> {
                statementService.create(statement, customerID);
                LOGGER.info("Statements created successfully");
            });
        }

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
