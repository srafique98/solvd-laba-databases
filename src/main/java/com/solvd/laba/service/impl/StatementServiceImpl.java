package com.solvd.laba.service.impl;

import com.solvd.laba.domain.Statement;
import com.solvd.laba.persistence.StatementRepository;
import com.solvd.laba.persistence.impl.StatementDAO;
import com.solvd.laba.persistence.mybatis.StatementMyBatisDAO;
import com.solvd.laba.service.StatementService;

import java.util.Optional;

public class StatementServiceImpl implements StatementService {
    private final StatementRepository statementRepository;

    public StatementServiceImpl() {

//        this.statementRepository = new StatementDAO();
        this.statementRepository = new StatementMyBatisDAO();
    }

    @Override
    public void update(Statement statement) {
        statementRepository.update(statement);
    }

    @Override
    public void create(Statement statement, Long accountID) {
        statement.setId(null);
        statementRepository.create(statement,accountID);
    }

    @Override
    public Optional<Statement> findById(Long id) {
        return statementRepository.findById(id);
    }
}
